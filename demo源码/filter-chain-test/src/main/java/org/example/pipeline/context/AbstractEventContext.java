package org.example.pipeline.context;


import lombok.Data;
import org.redisson.api.RLock;

/**
 * @author gim
 */
@Data
public abstract class AbstractEventContext implements EventContext {
    //是否继续执行链
    private boolean continueChain = true;

    //分布式锁
    private RLock rLock;

    @Override
    public boolean continueChain() {
        return continueChain;
    }
}
