package org.example.springframework.test.bean;

import cn.hutool.core.io.IoUtil;
import org.example.springfreamework.beans.BeansException;
import org.example.springfreamework.beans.PropertyValue;
import org.example.springfreamework.beans.PropertyValues;
import org.example.springfreamework.beans.factory.config.BeanDefinition;
import org.example.springfreamework.beans.factory.config.BeanReference;
import org.example.springfreamework.beans.factory.support.DefaultListableBeanFactory;
import org.example.springfreamework.beans.factory.xml.XmlBeanDefinitionReader;
import org.example.springfreamework.core.io.DefaultResourceLoader;
import org.example.springfreamework.core.io.Resource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {

    @Test
    public void test_BeanFactory() throws BeansException, InstantiationException, IllegalAccessException {
        //初始化Bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) beanFactory.getBean("userService",UserService.class);
        System.out.println(userService.queryUserInfo());
    }

    private DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();

    @Test
    public void test_classpath() throws IOException {
        Resource resource = defaultResourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = defaultResourceLoader.getResource(Thread.currentThread().getContextClassLoader().getResource("").getPath()+"important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException{
        Resource resource = defaultResourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }

}
