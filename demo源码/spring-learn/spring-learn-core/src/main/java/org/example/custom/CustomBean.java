package org.example.custom;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class CustomBean implements InitializingBean {

    public CustomBean() {
        System.out.println("CustomBean's construct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CustomBean's afterPropertiesSet");
    }
}
