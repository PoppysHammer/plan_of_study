package org.example.pipeline.basic.context;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.redisson.api.RLock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gim
 */
@Data
public abstract class AbstractEventContext implements EventContext {
    //是否继续执行链
    private Boolean continueChain = true;

    //分布式锁
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private Map<String, RLock> rLock = new HashMap<>();

    //是否可释放锁
    private Boolean canReleaseFlag = true;

    @Override
    public boolean continueChain() {
        return continueChain;
    }

    public void setRLock(String lockKey, RLock lock) {
        rLock.put(lockKey, lock);
    }

    public RLock getRLock(String lockKey) {
        return rLock.get(lockKey);
    }

    public Map<String, RLock> getRLockMap() {
        return rLock;
    }
}
