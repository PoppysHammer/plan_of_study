package org.example.demo.design;

import org.example.demo.design.impl.CacheServiceImpl;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void testCacheService(){
        CacheService cacheService = new CacheServiceImpl();
        cacheService.set("user_name_02","小付哥",1);
        String user_name_01 = cacheService.get("user_name_02", 1);
        System.out.println(user_name_01);
    }
}
