package org.example.demo.design.mode;

public class PayCypher implements IPayMode {
    @Override
    public boolean security(String uId) {
        System.out.println(("密码支付，风控校验环境安全"));
        return true;
    }
}
