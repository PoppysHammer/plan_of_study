package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.UserPointGetEntity;
import org.example.mapper.UserPointGetMapper;
import org.example.service.UserPointGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserPointGetServiceImpl extends ServiceImpl<UserPointGetMapper, UserPointGetEntity> implements UserPointGetService {

    @Resource
    private TestService testService;
    @Override
    public void test() {
        testService.test();
    }
}
