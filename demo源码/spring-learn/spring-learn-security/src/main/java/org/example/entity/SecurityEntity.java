package org.example.entity;

import com.alibaba.fastjson2.JSONObject;
import org.example.core.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class SecurityEntity implements CommandLineRunner {

    @Autowired
    @Qualifier("securityService3")
    private SecurityService securityService;

//    @Autowired
//    public void setSecurityService(SecurityService securityService1) {
//        this.securityService = securityService1;
//    }

    @Autowired
    public SecurityEntity(SecurityService securityService2) {
        System.out.println(securityService2.getClass().getAnnotation(Qualifier.class).value());
        System.out.println("this is SecurityEntity...");
    }

    @Autowired
    private List<SecurityService> securityServiceList;

    @Override
    public void run(String... args) throws Exception {
        securityServiceList.forEach(SecurityService::print);
//        System.out.println(securityService.getClass().getAnnotation(Qualifier.class).value());
    }
}
