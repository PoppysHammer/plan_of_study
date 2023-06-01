package org.example;

import org.example.config.CoreConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = {CoreApplication.class})
public class TestExample {

    @Resource
    private CoreConfig config;


    @Test
    public void abc(){
        System.out.println(config.coreEntity());
        System.out.println(config.coreEntity());
        System.out.println(config.coreEntity());
        System.out.println(config.coreEntity());
        System.out.println(config.coreEntity());

        System.out.println(config.coreEntity3());
        System.out.println(config.coreEntity3());
        System.out.println(config.coreEntity3());
        System.out.println(config.coreEntity3());
        System.out.println(config.coreEntity3());
    }
}
