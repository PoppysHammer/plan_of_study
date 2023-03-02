package org.example.springfreamework.beans.factory.support;

import org.example.springfreamework.beans.factory.config.BeanDefinition;

/**
 * 抽象自动装配能力bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 使用bean名称，beanDefinition创建单例对象
     *
     * @param beanName
     * @param beanDefinition
     * @return
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //创建单例对象
        addSingleton(beanName, bean);
        return bean;
    }
}
