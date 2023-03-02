package org.itstack.demo.design.store;

import java.util.Map;

/**
 * 定义发奖接口
 */
public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
