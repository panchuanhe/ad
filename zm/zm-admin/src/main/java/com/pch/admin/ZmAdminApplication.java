package com.pch.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
@MapperScan("com.pch.admin.mapper")
@EnableDiscoveryClient
public class ZmAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmAdminApplication.class, args);
    }

}
