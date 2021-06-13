package com.pch.advert.feign;

import com.pch.advert.entity.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zm-admin", fallback = AdminFeignFallback.class)
public interface AdminFeign {

    @GetMapping(value = "/user/{id}")
    UserVO selectById(@PathVariable("id") Long id);
}
