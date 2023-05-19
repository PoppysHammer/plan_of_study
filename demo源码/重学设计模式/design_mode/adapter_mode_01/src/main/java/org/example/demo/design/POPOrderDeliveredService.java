package org.example.demo.design;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.example.demo.design.mq.POPOrderDelivered;

public class POPOrderDeliveredService {


    private void onMessage(String message) {
        POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);

        System.out.println(StrUtil.format("创建第三方订单：{}", JSON.toJSONString(mq)));
    }
}
