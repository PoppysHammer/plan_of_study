package org.example.demo.design;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.example.demo.design.mq.CreateAccount;

public class CreateAccountMqService {

    private void onMessage(String message) {
        CreateAccount mq = JSON.parseObject(message, CreateAccount.class);

        System.out.println(StrUtil.format("创建账户：{}",JSON.toJSONString(mq)));
    }
}
