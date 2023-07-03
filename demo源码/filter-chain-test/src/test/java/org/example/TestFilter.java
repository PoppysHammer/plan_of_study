package org.example;

import org.example.config.ChargePipelineConfig;
import org.example.pipeline.FilterChainPipeline;
import org.example.pipeline.context.PointContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestFilter {

    @Resource
    private FilterChainPipeline pipeline;

    @Test
    public void abc(){
        pipeline.getFilterChain().handle(new PointContext());
    }
}
