package org.example.demo.design.util;

import java.util.*;

public class TopicRandomUtil {

    /**
     * 乱序Map元素 记录对应答案key
     *
     * @param: [option, key] 题目, 答案
     * @return: {@link org.example.demo.design.util.Topic}  乱序后{A=c., B=d., C=a., D=b.}
     * @author: poppy
     * @date: 2023/3/3 10:10 AM
     */
    static public Topic random(Map<String, String> option, String key) {
        Set<String> keySet = option.keySet();
        //题目选项重排
        ArrayList<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        HashMap<String, String> optionNew = new HashMap<>();
        int idx = 0;
        String keyNew = "";
        for (String next : keySet) {
            String randomKey = keyList.get(idx++);
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }
}
