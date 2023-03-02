package org.example.springfreamework.core.io;

/**
 * 获取资源接口
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
