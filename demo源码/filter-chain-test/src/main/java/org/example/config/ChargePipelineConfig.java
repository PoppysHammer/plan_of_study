package org.example.config;

import io.micrometer.core.instrument.util.StringUtils;
import org.example.filters.PointFilter1;
import org.example.filters.PointFilter2;
import org.example.filters.PointFilter3;
import org.example.filters.common.ContextVerifyFilter;
import org.example.filters.common.RedisLockFilter;
import org.example.filters.common.RedisUnLockFilter;
import org.example.pipeline.AbstractEventFilter;
import org.example.pipeline.FilterChainPipeline;
import org.example.pipeline.context.PointContext;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChargePipelineConfig {

    @Bean
    public FilterChainPipeline<AbstractEventFilter<PointContext>> chargePipeline(RedissonClient redissonClient) {
        FilterChainPipeline<AbstractEventFilter<PointContext>> filterChainPipeline = new FilterChainPipeline<>();
        filterChainPipeline.addNext(new ContextVerifyFilter<>((context) -> {
            if (StringUtils.isNotEmpty(context.getName())
                    && context.getPoint() != null) {
                throw new RuntimeException();
            }
        }
        ));//前置校验
        filterChainPipeline.addNext(new RedisLockFilter<>(redissonClient, (context) ->
                "preLock:" + context.getUserId()));//加锁
        filterChainPipeline.addNext(new PointFilter1());
        filterChainPipeline.addNext(new PointFilter2());
        filterChainPipeline.addNext(new RedisUnLockFilter<>());//放锁
        filterChainPipeline.addNext(new PointFilter3());
        return filterChainPipeline;
    }

}
