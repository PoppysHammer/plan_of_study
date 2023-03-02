package org.example.springfreamework.beans.factory;

import org.example.springfreamework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
