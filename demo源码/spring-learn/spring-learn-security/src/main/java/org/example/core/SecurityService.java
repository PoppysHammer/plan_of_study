package org.example.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@Qualifier("securityService5")
public class SecurityService implements BeanNameAware, ApplicationContextAware, BeanFactoryAware {
    private String beanName;

    private ApplicationContext applicationContext;

    public SecurityService() {
        System.out.println("this is SecurityService...:" + beanName);
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    public void print() {
        System.out.println("this is my name...:" + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println(applicationContext);
    }

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        Object applicationContext = beanFactory.getBean("securityConfig");
        System.out.println(applicationContext+"-----");
    }

}
