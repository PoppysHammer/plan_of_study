package org.example.demo.design.test;


import org.example.demo.design.QuestionBankController;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void test_DecorationPackageController() throws CloneNotSupportedException{
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "123213j2189543912"));
        System.out.println(questionBankController.createPaper("大豆", "9898734135454345"));
        System.out.println(questionBankController.createPaper("小米", "678637853154542"));
        System.out.println(questionBankController.createPaper("苍蝇", "8798763517644454"));
    }
}
