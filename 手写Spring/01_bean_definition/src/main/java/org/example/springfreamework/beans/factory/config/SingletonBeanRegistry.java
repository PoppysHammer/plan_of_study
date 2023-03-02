package org.example.springfreamework.beans.factory.config;

public interface SingletonBeanRegistry {
    /**
     * 通过beanName获取单例对象
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
