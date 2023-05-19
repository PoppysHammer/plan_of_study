package org.example.demo.design.test;


import org.example.demo.design.PayController;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ApiTest {

    @Test
    public void test_pay() {
        PayController payController = new PayController();
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        payController.pay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        payController.pay("jlu19dlxo111", "100000109894", new BigDecimal(100), 2, 3);
    }
}
