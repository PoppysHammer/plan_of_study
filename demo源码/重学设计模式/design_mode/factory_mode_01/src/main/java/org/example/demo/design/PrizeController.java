package org.example.demo.design;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PrizeController {
    private Logger log = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSONObject.toJSONString(req);
        AwardRes awardRes = null;
        try {
            log.info("奖品发放开始{}。req:{}", req.getUid(), reqJson);
            if (req.getAwardType() == 1) {
                System.out.println("请求参数[优惠券] => req：" + JSON.toJSON(req));
                System.out.println("测试结果[优惠券]：{xxxxxxxx}");
            } else if (req.getAwardType() == 2) {
                System.out.println("请求参数[实物商品] => req：" + JSON.toJSON(req));
                System.out.println("测试结果[实物商品]：{xxxxxxxx}");
            } else if (req.getAwardType() == 3) {
                System.out.println("请求参数[爱奇艺兑换卡] => req：" + JSON.toJSON(req));
                System.out.println("测试结果[爱奇艺兑换卡]：{xxxxxxxx}");
            }
            log.info("奖品发放完成{}。", req.getUid());
        } catch (Exception e) {
            log.error("奖品发放失败{}。req:{}", req.getUid(), reqJson);
            awardRes = new AwardRes("0001", e.getMessage());
        }

        return awardRes;
    }
}
