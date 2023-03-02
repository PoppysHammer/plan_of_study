package org.itstack.demo.design.store.impl;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.store.ICommodity;

import java.util.Map;

public class CardCommodityService implements ICommodity {


    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        System.out.println("请求参数[爱奇艺兑换卡] => uId：" + uId + " commodityId：" + commodityId + " bizId：" + bizId + " extMap：" + JSON.toJSON(extMap));
        System.out.println("测试结果[爱奇艺兑换卡]：{xxxxxxxx}");
    }
}
