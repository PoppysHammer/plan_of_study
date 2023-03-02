package org.itstack.demo.design.store.impl;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.store.ICommodity;

import java.util.Map;

public class GoodsCommodityService implements ICommodity {


    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        System.out.println("请求参数[实物商品]=> uId：" + uId + " commodityId：" + commodityId + " bizId：" + bizId + " extMap：" + JSON.toJSON(extMap));
        System.out.println("测试结果[实物商品]：{xxxxxxxx}");
    }
}
