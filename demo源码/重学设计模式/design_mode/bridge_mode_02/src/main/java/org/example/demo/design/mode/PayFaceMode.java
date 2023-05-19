package org.example.demo.design.mode;

import cn.hutool.core.util.StrUtil;

public class PayFaceMode implements IPayMode {

    @Override
    public boolean security(String uId) {
        System.out.println(StrUtil.format("人脸支付，风控校验脸部识别"));
        return true;
    }
}
