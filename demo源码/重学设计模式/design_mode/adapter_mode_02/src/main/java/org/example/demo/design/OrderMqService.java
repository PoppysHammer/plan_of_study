package org.example.demo.design;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.example.demo.design.mq.CreateAccount;
import org.example.demo.design.mq.OrderMq;

public class OrderMqService {


    private void onMessage(String message) {
        OrderMq mq = JSON.parseObject(message, OrderMq.class);

        System.out.println(StrUtil.format("创建订单：{}",JSON.toJSONString(mq)));
    }
}
