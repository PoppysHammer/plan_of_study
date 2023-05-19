package org.example.demo.design;

import cn.hutool.core.util.StrUtil;

import java.math.BigDecimal;

public class PayController {

    /**
     * 用户id、交易单id、金额、支付渠道、支付模式
     *
     * @param: [uId, tradeId, amount, channelType, modeType]
     * @return: {@link boolean}
     * @author: poppy
     * @date: 2023/3/15 11:00 AM
     */
    public boolean pay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        if (1 == channelType) {
            System.out.println(StrUtil.format("模拟微信渠道支付转账开始：uid:{},tradeId:{},amount:{}", uId, tradeId, amount));
            if (1 == modeType) {
                System.out.println(StrUtil.format("密码支付，风控校验环境安全"));
            } else if (2 == modeType) {
                System.out.println(StrUtil.format("密码支付，风控校验环境安全"));
            } else if (3 == modeType) {
                System.out.println(StrUtil.format("指纹支付，风控校验指纹信息"));
            }
        } else if (2 == channelType) {
            System.out.println(StrUtil.format("模拟支付宝渠道支付转账开始：uid:{},tradeId:{},amount:{}", uId, tradeId, amount));
            if (1 == modeType) {
                System.out.println(StrUtil.format("密码支付，风控校验环境安全"));
            } else if (2 == modeType) {
                System.out.println(StrUtil.format("密码支付，风控校验环境安全"));
            } else if (3 == modeType) {
                System.out.println(StrUtil.format("指纹支付，风控校验指纹信息"));
            }
        }
        return true;
    }
}
