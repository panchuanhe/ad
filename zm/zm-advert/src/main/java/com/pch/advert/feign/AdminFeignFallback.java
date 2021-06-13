package com.pch.advert.feign;

import com.pch.advert.entity.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AdminFeignFallback implements AdminFeign {

    @Override
    public UserVO selectById(Long id) {
        UserVO userVO = new UserVO();
        userVO.setUserName("我是备用用户");
        return userVO;
    }
}
