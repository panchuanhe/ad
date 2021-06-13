package com.pch.advert;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan(value = "com.pch.advert.mapper")
@SpringBootApplication
public class ZmAdvertApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmAdvertApplication.class, args);
    }

}
