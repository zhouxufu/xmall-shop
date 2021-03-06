package com.xmall.auth.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author zhouxufu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthorizationServer
public class XmallAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmallAuthApplication.class, args);
    }
}
