package org.example.demo.design.service;

import cn.hutool.core.util.StrUtil;

public class POPOrderService {

    public boolean isFirstOrder(String uId) {
        System.out.println(StrUtil.format("POP商家，查询用户的订单是否为首单：{}", uId));
        return true;
    }
}
