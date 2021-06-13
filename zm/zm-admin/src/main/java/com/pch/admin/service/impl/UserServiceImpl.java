package com.pch.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.admin.entity.UserDO;
import com.pch.admin.mapper.UserMapper;
import com.pch.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
@RefreshScope
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Value("${name}")
    private String userName;


    @Override
    public UserDO selectByPrimaryKey(Long id) {

        UserDO userDO = userMapper.selectByPrimaryKey(id);
        userDO.setUserName(userName);
        log.info("==============" + userName);
        return userDO;
    }
}
