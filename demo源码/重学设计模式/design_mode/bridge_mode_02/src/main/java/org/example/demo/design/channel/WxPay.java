package org.example.demo.design.channel;

import cn.hutool.core.util.StrUtil;
import org.example.demo.design.mode.IPayMode;

import java.math.BigDecimal;

public class WxPay extends Pay {

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        System.out.println(StrUtil.format("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount));
        boolean security = payMode.security(uId);
        if (!security) {
            System.out.println(StrUtil.format("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount));
            return "0001";
        }
        System.out.println(StrUtil.format("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount));
        return "0000";
    }
}
