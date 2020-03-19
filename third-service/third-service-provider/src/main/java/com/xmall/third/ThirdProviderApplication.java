package com.xmall.third;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhouxufu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo()
public class ThirdProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdProviderApplication.class, args);
    }
}
