package org.example.springfreamework.beans;

public class BeansException extends Exception {

    public BeansException(String msg) {
        System.out.println(msg);
    }

    public BeansException(String msg, Exception e) {
        e.printStackTrace();
        System.out.println(msg);
    }
}
