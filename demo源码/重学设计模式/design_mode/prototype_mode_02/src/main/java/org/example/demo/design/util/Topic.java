package org.example.demo.design.util;

import java.util.Map;

public class Topic {

    private Map<String, String> optionNew;   //新题目

    private String keyNew;  //新答案

    public Topic() {
    }

    public Topic(Map<String, String> optionNew, String keyNew) {
        this.optionNew = optionNew;
        this.keyNew = keyNew;
    }

    public Map<String, String> getOptionNew() {
        return optionNew;
    }

    public void setOptionNew(Map<String, String> optionNew) {
        this.optionNew = optionNew;
    }

    public String getKeyNew() {
        return keyNew;
    }

    public void setKeyNew(String keyNew) {
        this.keyNew = keyNew;
    }
}
