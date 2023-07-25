package org.example.pipeline.basic;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pipeline.basic.context.AbstractEventContext;
import org.redisson.api.RLock;

import java.util.Map;

/**
 * @author gim 模板方法
 */
@Slf4j
@RequiredArgsConstructor
public abstract class AbstractHandler<T extends AbstractEventContext> implements Handler<T> {

    private Handler<T> next;

    @Override
    public final void doHandle(T context) throws Exception {
        try {
            execute(context);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                exceptionCaught(context, e);
            } catch (Exception ex) {
                fireException(context, ex);
            }
            log.info("【责任链异常】触发自动放锁，当前锁数量：{}", context.getRLockMap().size());
            releaseLockMap(context);
        }
        if (context.getContinueChain() && next != null) {
            next.doHandle(context);
        } else {
            if (context.getCanReleaseFlag()) {
                log.info("【责任链结束】触发自动放锁，当前锁数量：{}", context.getRLockMap().size());
                releaseLockMap(context);
            }
        }

    }

    /**
     * 处理器执行
     *
     * @param: [context]
     * @return:
     * @author: poppy
     * @date: 2023/7/24 10:40 AM
     */
    private void execute(T context) throws Exception {
        boolean expression = handleVerify(context);
        if (!expression) {
            log.error("【编排参数异常】当前执行器：{}", this.getClass().getName());
            throw new RuntimeException("编排参数异常");
//            ResponseEnum.LAYOUT_PARAM_ERROR.fail();
        }
        handle(context);
    }

    /**
     * 处理器处理逻辑（handler重写此方法用于实现自己业务，默认空实现）
     *
     * @param context 处理器上下文
     */
    protected void handle(T context) throws Exception {
    }

    @Override
    public void next(Handler<T> next) {
        this.next = next;
    }

    @Override
    public void exceptionCaught(T context, Exception e) throws Exception {
        fireException(context, e);
    }

    @Override
    public final void fireException(T context, Exception e) throws Exception {
        if (next != null) {
            this.next.fireException(context, e);
        } else {
            //释放所有锁
            releaseLockMap(context);
            throw e;
        }
    }

    /**
     * 释放所有锁
     *
     * @param context
     */
    private void releaseLockMap(T context) {
        Map<String, RLock> rLockMap = context.getRLockMap();
        rLockMap.keySet().forEach(lockKey -> releaseLock(lockKey, context));
    }

    public void releaseLock(String lockKey, T context) {
        RLock rLock = context.getRLock(lockKey);
        if (rLock != null && rLock.isLocked() && rLock.isHeldByCurrentThread()) {
            log.info("【释放锁】分布式锁：{}，释放", rLock.getName());
            rLock.unlock();
        }
    }

}
