package org.example.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.beans.factory.serviceloader.ServiceFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfig {

    @Bean("payFactory")
    public FactoryBean payFactory(){
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();

        serviceLocatorFactoryBean.setServiceLocatorInterface(PayFactory.class);
        return serviceLocatorFactoryBean;
    }
}
