package org.example.springfreamework.beans.factory.support;

import org.example.springfreamework.beans.BeansException;
import org.example.springfreamework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {

    /**
     * 实例化
     *
     * @param beanDefinition  bean定义
     * @param beanName  bean名称
     * @param ctor  含有必要的类信息 目的是为了拿到符合入参信息相对应的构造函数
     * @param args  构造方法参数列表
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}