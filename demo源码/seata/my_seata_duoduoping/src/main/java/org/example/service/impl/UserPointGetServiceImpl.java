package org.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.UserPointGet;
import org.example.mapper.UserPointGetMapper;
import org.example.service.AppCloud;
import org.example.service.UserPointGetService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Slf4j
public class UserPointGetServiceImpl extends ServiceImpl<UserPointGetMapper, UserPointGet> implements UserPointGetService {

    @Resource
    private AppCloud appCloud;

    @GlobalTransactional(name = "test-global", rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void changePoint(Long id, Integer point, Long appId) {
        System.out.println(RootContext.getXID());
        UserPointGet userPointGet = new UserPointGet();
        userPointGet.setId(id);
        userPointGet.setPointGet(point);
        this.baseMapper.updateById(userPointGet);

        appCloud.changePoint(appId, point);
        int i = 1/0;
    }

}
