package org.example.springframework.test.bean;

import org.example.springfreamework.beans.BeansException;
import org.example.springfreamework.beans.factory.config.BeanDefinition;
import org.example.springfreamework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() throws BeansException {
        //初始化Bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //第一次获取bean对象
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserService();

        //第二次获取bean对象
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserService();
    }


}
