package org.example.demo.design.test;


import cn.hutool.core.util.StrUtil;
import org.example.demo.design.EngineController;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_EngineController() {
        EngineController engineController = new EngineController();
        String process = engineController.process("123120983", "技术", "项目经理");
        System.out.println(StrUtil.format("测试结果：{}", process));

    }


}
