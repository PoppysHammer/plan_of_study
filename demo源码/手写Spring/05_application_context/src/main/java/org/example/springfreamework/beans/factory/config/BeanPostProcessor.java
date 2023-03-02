package org.example.springfreamework.beans.factory.config;

import org.example.springfreamework.beans.BeansException;

public interface BeanPostProcessor {

    /**
     * 在bean对象执行初始化方法之前，执行此方法
     *
     * @param: [bean, beanName]
     * @return: {@link java.lang.Object}
     * @author: poppy
     * @date: 2023/2/22 10:45 AM
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean对象执行方法初始化之后，执行此方法
     *
     * @param: [bean, beanName]
     * @return: {@link java.lang.Object}
     * @author: poppy
     * @date: 2023/2/22 10:45 AM
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
