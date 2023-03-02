package org.example.demo.design.test;


import org.example.demo.design.DecorationPackageController;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ApiTest {

    @Test
    public void test_DecorationPackageController(){
        DecorationPackageController decoration = new DecorationPackageController();
        // 豪华欧式
        System.out.println(decoration.getMatterList(new BigDecimal("100"),1));
        // 轻奢田园
        System.out.println(decoration.getMatterList(new BigDecimal("100"),2));
        // 现代简约
        System.out.println(decoration.getMatterList(new BigDecimal("100"),3));
    }
}
