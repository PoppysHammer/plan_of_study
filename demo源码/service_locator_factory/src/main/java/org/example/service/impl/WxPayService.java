package org.example.service.impl;

import org.example.service.PayService;
import org.springframework.stereotype.Component;

@Component
public class WxPayService implements PayService {
    @Override
    public void pay() {
        System.out.println("wxPay.....");
    }
}
