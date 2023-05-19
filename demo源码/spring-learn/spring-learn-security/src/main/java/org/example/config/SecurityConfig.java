package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class SecurityConfig {

    public SecurityConfig() {
        System.out.println("this is SecurityConfig...");
    }
}
