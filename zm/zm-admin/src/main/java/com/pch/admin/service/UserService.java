package com.pch.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.admin.entity.UserDO;

public interface UserService extends IService<UserDO> {

    UserDO selectByPrimaryKey(Long id);
}
