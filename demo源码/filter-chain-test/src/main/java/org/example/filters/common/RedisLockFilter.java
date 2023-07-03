package org.example.filters.common;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pipeline.AbstractEventFilter;
import org.example.pipeline.context.AbstractEventContext;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;


@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
public class RedisLockFilter<T extends AbstractEventContext> extends AbstractEventFilter<T> {
    private final RedissonClient redissonClient;
    private final Function<T, String> lockFunction;
    private long lockWaitTime = 0;
    private TimeUnit lockTimeUnit = TimeUnit.MILLISECONDS;

    @Override
    protected void handle(T context) {
        RLock rLock = redissonClient.getLock(lockFunction.apply(context));
        try {
            boolean lockFlag = rLock.tryLock(lockWaitTime, lockTimeUnit);
            if (!lockFlag) {
                throw new RuntimeException("分布式锁获取失败");
            }
            context.setRLock(rLock);
            log.info("【分布式锁】锁：{}，成功！", rLock.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
