package com.xmall.user.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhouxufu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmallUserApplication.class, args);
    }
}
