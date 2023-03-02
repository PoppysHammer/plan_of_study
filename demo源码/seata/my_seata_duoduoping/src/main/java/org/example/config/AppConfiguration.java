package org.example.config;

import feign.Feign;
import feign.Request;
import feign.jackson.JacksonDecoder;
import lombok.extern.slf4j.Slf4j;
import org.example.service.AppCloud;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * app服务配置
 *
 * @author wb
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class AppConfiguration {

    @Resource
    private AppProperties appProperties;

    @Bean
    public AppInterceptor appInterceptor() {
        return new AppInterceptor();
    }

    @Bean
    public AppCloud pointBootProCloud(AppInterceptor appInterceptor) {
        return Feign.builder().decoder(new JacksonDecoder()).requestInterceptor(appInterceptor)
                .options(new Request.Options(5, TimeUnit.SECONDS, 5, TimeUnit.SECONDS, true))
                .target(AppCloud.class, appProperties.getUrl());
    }

}
