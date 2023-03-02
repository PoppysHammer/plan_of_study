package org.example.controller;

import io.seata.core.context.RootContext;
import org.apache.ibatis.annotations.Param;
import org.example.service.impl.UserPointGetServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/app")
@RestController
public class UserPointGetController {

    @Resource
    private UserPointGetServiceImpl userPointGetServiceImpl;

    @RequestMapping("/changePoint")
    public void changePoint(@RequestParam("id") Long id, @RequestParam("point") Integer point) {
        System.out.println(RootContext.getXID());
        userPointGetServiceImpl.changePoint(id, point);
    }
}
