package org.example.entity;

import org.springframework.stereotype.Component;

@Component
public class CoreEntity {

    public CoreEntity() {

    }

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            abc();
        });
        Thread b = new Thread(() -> {
            abc();
        });
        a.start();
        b.start();
    }

    public synchronized static void abc() {
        System.out.println("111111111111111");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String testInit() {
        System.out.println("123213232");
        return "";
    }
}
