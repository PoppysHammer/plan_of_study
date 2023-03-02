package org.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.UserPointGet;
import org.example.mapper.UserPointGetMapper;
import org.example.service.UserPointGetService;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserPointGetServiceImpl extends ServiceImpl<UserPointGetMapper, UserPointGet> implements UserPointGetService {


    public void changePoint(Long id, Integer point) {
        UserPointGet userPointGet = new UserPointGet();
        userPointGet.setId(id);
        userPointGet.setPointGet(point);
        this.baseMapper.updateById(userPointGet);
    }

}
