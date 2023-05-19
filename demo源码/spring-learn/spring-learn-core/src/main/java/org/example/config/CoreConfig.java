package org.example.config;

import org.example.entity.CoreEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:bean.xml")
public class CoreConfig {

//    @Bean(initMethod = "testInit")
    public CoreEntity coreEntity() {
        System.out.println("this is coreEntity2...");
        return new CoreEntity();
    }

    public CoreConfig() {
        System.out.println("this is CoreConfig...");
    }
}
