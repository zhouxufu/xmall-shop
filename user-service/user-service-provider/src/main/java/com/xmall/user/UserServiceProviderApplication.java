package com.xmall.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhouxufu
 */
@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
@MapperScan(basePackages = "com.xmall.user.repository.mapper")
@org.mybatis.spring.annotation.MapperScan(basePackages = "com.xmall.user.repository.mapper")
public class UserServiceProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }

}
