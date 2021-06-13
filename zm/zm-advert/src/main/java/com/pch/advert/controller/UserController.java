package com.pch.advert.controller;

import com.alibaba.fastjson.JSONObject;
import com.pch.advert.entity.vo.UserVO;
import com.pch.advert.feign.AdminFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private AdminFeign adminFeign;

    @GetMapping(value = "/{id}")
    public String queryById(@PathVariable("id") Long id) {
        UserVO userVO = adminFeign.selectById(id);

        return JSONObject.toJSONString(userVO);
    }
}
