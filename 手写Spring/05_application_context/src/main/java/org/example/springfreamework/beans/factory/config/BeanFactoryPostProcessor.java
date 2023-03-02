package org.example.springfreamework.beans.factory.config;

import org.example.springfreamework.beans.BeansException;
import org.example.springfreamework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    /**
     * 在所有的BeanDefinition加载完成后，实例化Bean对象之前，提供修改BeanDefinition属性的机制
     *
     * @param: [beanFactory]
     * @return:
     * @author: poppy
     * @date: 2023/2/22 10:39 AM
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
