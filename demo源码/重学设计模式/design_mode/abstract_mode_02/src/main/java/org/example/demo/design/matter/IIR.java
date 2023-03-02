package org.example.demo.design.matter;

import cn.hutool.core.text.StrFormatter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class IIR {

    private Map<String,String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        System.out.println(StrFormatter.format("IIR获取数据 key：{}", key));
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        System.out.println(StrFormatter.format("IIR写入数据 key:{}", key));
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        System.out.println(StrFormatter.format("IIR写入数据 key:{} val:{} timeout:{} timeUnit:{}", key, value, timeout, timeUnit));
        dataMap.put(key, value);
    }

    public void del(String key) {
        System.out.println(StrFormatter.format("IIR删除数据 key：{}", key));
        dataMap.remove(key);
    }
}
