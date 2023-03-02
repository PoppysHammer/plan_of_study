package org.example.config;

import com.alibaba.fastjson.JSONObject;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public class AppInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Map<String, Collection<String>> headers = new HashMap<>();
        headers.put(RootContext.KEY_XID, Collections.singletonList(RootContext.getXID()));

        log.info("【feign请求拦截】即将为请求路径：{}，置入请求头：{}", requestTemplate.path(), JSONObject.toJSONString(headers));

        requestTemplate.headers(headers);
    }
}
