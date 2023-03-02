package org.example.springfreamework.beans.factory.config;

import org.example.springfreamework.beans.factory.HierarchicalBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanProcessor(BeanPostProcessor beanPostProcessor);
}
