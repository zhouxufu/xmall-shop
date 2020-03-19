package com.xmall.third.biz.sms;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhouxufu
 */
@Component
@RefreshScope
@Getter
public class SmsProperties {

    @Value(value = "${sms.aliyun.sign-name}")
    private String signName;

    @Value(value = "${sms.aliyun.template-code}")
    private Map<String, String> templateCodeMap;

}
