package org.example.demo.design.service;

import cn.hutool.core.util.StrUtil;

public class OrderService {

    public long queryUserOrderCount(String userId) {
        System.out.println(StrUtil.format("自营商家，查询用户的订单是否为首单：{}", userId));
        return 10L;
    }
}
