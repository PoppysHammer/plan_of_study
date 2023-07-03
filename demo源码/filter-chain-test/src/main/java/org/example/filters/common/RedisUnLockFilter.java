package org.example.filters.common;

import lombok.extern.slf4j.Slf4j;
import org.example.pipeline.AbstractEventFilter;
import org.example.pipeline.context.AbstractEventContext;

@Slf4j
public class RedisUnLockFilter<T extends AbstractEventContext> extends AbstractEventFilter<T> {

    @Override
    protected void handle(T context) throws InterruptedException {
        log.info("【主动释放锁】");
        super.releaseLock(context);
    }
}
