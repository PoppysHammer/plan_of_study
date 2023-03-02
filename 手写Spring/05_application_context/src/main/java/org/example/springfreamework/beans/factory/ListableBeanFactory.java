package org.example.springfreamework.beans.factory;

import org.example.springfreamework.beans.factory.config.BeanDefinition;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String,T> getBeansOfType(Class<T> type);

    String[] getBeanDefinitionNames();
}
