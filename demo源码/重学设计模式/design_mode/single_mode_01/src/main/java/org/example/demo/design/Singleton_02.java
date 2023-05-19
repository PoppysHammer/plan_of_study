package org.example.demo.design;

/**
 * 懒汉 线程安全
 */
public class Singleton_02 {

    private static Singleton_02 instance;


    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance() {
        if (instance == null)
            instance = new Singleton_02();
        return instance;
    }
}
