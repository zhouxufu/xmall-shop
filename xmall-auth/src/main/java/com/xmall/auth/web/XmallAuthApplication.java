package com.xmall.auth.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author zhouxufu
 */
@SpringBootApplication
@EnableAuthorizationServer
public class XmallAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmallAuthApplication.class, args);
    }
}
