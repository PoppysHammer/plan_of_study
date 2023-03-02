package org.example.service.impl;

import org.example.mapper.UserPointGetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {
    @Resource
    private UserPointGetMapper userPointGetMapper;

    public void test() {
        System.out.println(userPointGetMapper.selectList(null));
    }
}
