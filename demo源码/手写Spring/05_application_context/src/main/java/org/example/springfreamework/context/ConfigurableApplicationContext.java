package org.example.springfreamework.context;

import org.example.springfreamework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @param: []
     * @return:
     * @author: poppy
     * @date: 2023/2/22 10:59 AM
     */
    void refresh() throws BeansException;
}
