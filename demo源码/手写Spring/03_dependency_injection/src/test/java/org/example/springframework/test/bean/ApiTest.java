package org.example.springframework.test.bean;

import org.example.springfreamework.beans.BeansException;
import org.example.springfreamework.beans.PropertyValue;
import org.example.springfreamework.beans.PropertyValues;
import org.example.springfreamework.beans.factory.config.BeanDefinition;
import org.example.springfreamework.beans.factory.config.BeanReference;
import org.example.springfreamework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() throws BeansException, InstantiationException, IllegalAccessException {
        //初始化Bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        // UserService设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10002"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
