package com.xmall.third.biz.sms;

import com.alibaba.alicloud.sms.ISmsService;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 短信发送工具
 *
 * @author zhouxufu
 */
@Component
@Slf4j
public class SmsSender {

    private final ISmsService smsService;

    public SmsSender(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") ISmsService smsService) {
        this.smsService = smsService;
    }

    /**
     * 发送短信
     *
     * @param smsContext 发送内容
     * @return 返回短信上下文
     */
    public SmsContext sendSms(SmsContext smsContext) {
        //创建短信请求对象，执行发送信息
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(smsContext.getReceive());
        request.setSignName(smsContext.getSign());
        request.setTemplateCode(smsContext.getTemplateCode());
        request.setTemplateParam(smsContext.getSmsBody());
        SendSmsResponse sendSmsResponse;
        try {
            sendSmsResponse = smsService.sendSmsRequest(request);
            smsContext.setBizId(sendSmsResponse.getBizId());
        } catch (ClientException e) {
            log.error("发送短信时候异常 context={}", smsContext, e);
            return smsContext;
        }
        return smsContext;
    }
}
