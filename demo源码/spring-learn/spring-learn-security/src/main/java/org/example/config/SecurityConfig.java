package org.example.config;

import org.example.core.SecurityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class SecurityConfig {

    public SecurityConfig() {
        System.out.println("this is SecurityConfig...");
    }

    @Bean
    @Qualifier("securityService1")
    public SecurityService securityService1() {
        System.out.println(1111111);
        return new SecurityService();
    }


    @Bean
    public SecurityService securityService2() {
        System.out.println(2222222);
        return new SecurityService();
    }


    @Bean
    public SecurityService securityService3() {
        System.out.println(3333333);
        return new SecurityService();
    }
}
