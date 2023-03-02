package org.example.demo.design.matter;

import cn.hutool.core.text.StrFormatter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class EGM {

    private Map<String,String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        System.out.println(StrFormatter.format("EGM获取数据 key：{}", key));
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        System.out.println(StrFormatter.format("EGM写入数据 key:{}", key));
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        System.out.println(StrFormatter.format("EGM写入数据 key:{} val:{} timeout:{} timeUnit:{}", key, value, timeout, timeUnit));
        dataMap.put(key, value);
    }

    public void delete(String key) {
        System.out.println(StrFormatter.format("EGM删除数据 key：{}", key));
        dataMap.remove(key);
    }
}
