package org.example.pipeline;


import lombok.extern.slf4j.Slf4j;
import org.example.pipeline.context.AbstractEventContext;

/**
 * @author gim 模板方法
 */
@Slf4j
public abstract class AbstractEventFilter<T extends AbstractEventContext> implements EventFilter<T> {

    @Override
    public void doFilter(T context, EventFilterChain chain) {
        try {
            handle(context);
        } catch (Exception e) {
            e.printStackTrace();
            releaseLock(context);
            context.setContinueChain(false);
            throw new RuntimeException(e);
        }
        if (context.continueChain() && chain.hasNext()) {
            chain.fireNext(context);
        } else {
            releaseLock(context);
        }
    }

    public void releaseLock(T context) {
        if (context.getRLock() != null && context.getRLock().isLocked() && context.getRLock().isHeldByCurrentThread()) {
            log.info("【释放锁】分布式锁：{}，释放", context.getRLock().getName());
            context.getRLock().unlock();
        }
    }

    protected abstract void handle(T context) throws InterruptedException;
}
