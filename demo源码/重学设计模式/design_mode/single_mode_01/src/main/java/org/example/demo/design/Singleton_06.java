package org.example.demo.design;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton_06 {
    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<>();

    private Singleton_06(){

    }

    public static final Singleton_06 getInstance(){

        for (; ;){
            Singleton_06 instance = INSTANCE.get();
            if (null != instance) return instance;
            INSTANCE.compareAndSet(null,new Singleton_06());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }


}
