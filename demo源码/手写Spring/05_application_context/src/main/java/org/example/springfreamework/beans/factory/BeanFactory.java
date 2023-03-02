package org.example.springfreamework.beans.factory;

import org.example.springfreamework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    /**
     * 重载 用于创建有参实例
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;


}
