package org.example.demo.design;

import org.example.demo.design.factory.JDKProxy;
import org.example.demo.design.factory.impl.CacheServiceImpl;
import org.example.demo.design.factory.impl.EGMCacheAdapter;
import org.example.demo.design.factory.impl.IIRCacheAdapter;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void testCacheService() throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小付哥");

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "乌拉拉");
        String val01 = proxy_EGM.get("user_name_01");
        String val02 = proxy_IIR.get("user_name_01");

        System.out.println(val01);
        System.out.println(val02);
    }
}
