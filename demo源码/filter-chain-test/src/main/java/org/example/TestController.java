package org.example;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    public String abc(String a){
        return a;
    }

}
