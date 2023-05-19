package org.example.demo.design.channel;

import org.example.demo.design.mode.IPayMode;

import java.math.BigDecimal;

public abstract class Pay {
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
