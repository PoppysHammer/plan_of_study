package org.example.springfreamework.context.support;

import org.example.springfreamework.beans.BeansException;
import org.example.springfreamework.beans.factory.ConfigurableListableBeanFactory;
import org.example.springfreamework.beans.factory.config.BeanFactoryPostProcessor;
import org.example.springfreamework.beans.factory.config.BeanPostProcessor;
import org.example.springfreamework.context.ConfigurableApplicationContext;
import org.example.springfreamework.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        //创建Bean工厂，并加载BeanDefinition
        refreshBeanFactory();

        //获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        //在Bean实例化之前执行beanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //BeanPostProcessor需要提前于其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanProcessor(beanPostProcessor);
        }
    }
}
