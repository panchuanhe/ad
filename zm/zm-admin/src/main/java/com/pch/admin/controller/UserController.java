package com.pch.admin.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pch.admin.entity.UserDO;
import com.pch.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userServiceImpl;

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello word";
    }

    @PostMapping(value = "/toMain")
    public String toMain() {
        return "redirect:main.html";
    }

    @PostMapping(value = "/toError")
    public String toError() {
        return "redirect:error.html";
    }

    @HystrixCommand(fallbackMethod = "errorFallback")
    @GetMapping(value = "/{id}")
    public UserDO findById(@PathVariable("id") Long id) throws InterruptedException {
        Thread.sleep(7000L);
        return userServiceImpl.selectByPrimaryKey(id);
    }

    private UserDO errorFallback(Long id) {
        UserDO userDO = new UserDO();
        userDO.setUserName("方法超时，我是兜底文案");
        return userDO;
    }
}
