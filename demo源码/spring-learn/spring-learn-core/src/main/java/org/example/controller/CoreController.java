package org.example.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreController {
    @Lazy
    @RequestMapping(value = "/test", params = {"name=小王"})
    public String abc() {
        System.out.println("11111");
        return "ababababab";
    }

    @Lazy
    @RequestMapping(value = "/test", params = {"name!=小王"})
    public String bcd() {
        return "bcdbcdbdcbdb";
    }

    @Lazy
    @RequestMapping(value = "/test")
    public String eee() {
        return "eeeeeee";
    }
}
