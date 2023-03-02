package org.example.demo.design.test;


import org.example.demo.design.Builder;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_Builder() {
        Builder builder = new Builder();
        // 豪华欧式
        System.out.println(builder.levelOne(100.00).getDetail());
        // 轻奢田园
        System.out.println(builder.levelTwo(100.00).getDetail());
        // 现代简约
        System.out.println(builder.levelThree(100.00).getDetail());
    }
}
