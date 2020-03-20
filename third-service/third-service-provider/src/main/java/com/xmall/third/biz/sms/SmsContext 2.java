package com.xmall.third.biz.sms;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 发送短信请求封装上下文对象
 *
 * @author zhouxufu
 */
@Getter
@ToString
public class SmsContext {
    private String receive;

    private String sign;

    private String templateCode;

    private String smsBody;

    @Setter
    private String bizId;

    public SmsContext(String receive, String sign, String templateCode) {
        this.receive = receive;
        this.sign = sign;
        this.templateCode = templateCode;
    }

    public SmsBodyBuilder smsBodyBuilder() {
        return new SmsBodyBuilder(this);
    }

    public class SmsBodyBuilder {
        private SmsContext smsContext;
        private JSONObject smsBodyJson = new JSONObject();

        public SmsBodyBuilder(SmsContext smsContext) {
            this.smsContext = smsContext;
        }

        public SmsBodyBuilder addKeyValue(String key, String value) {
            smsBodyJson.put(key, value);
            return this;
        }

        public SmsContext build() {
            smsBody = smsBodyJson.toJSONString();
            return smsContext;
        }
    }
}