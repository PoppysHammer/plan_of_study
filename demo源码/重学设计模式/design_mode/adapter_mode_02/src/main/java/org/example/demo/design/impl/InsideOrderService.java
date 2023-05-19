package org.example.demo.design.impl;

import org.example.demo.design.OrderAdapterService;
import org.example.demo.design.service.OrderService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
