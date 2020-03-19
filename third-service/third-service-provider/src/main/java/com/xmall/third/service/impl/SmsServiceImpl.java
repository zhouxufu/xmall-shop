package com.xmall.third.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.xmall.common.core.response.CommonResult;
import com.xmall.third.biz.sms.SmsContext;
import com.xmall.third.biz.sms.SmsProperties;
import com.xmall.third.biz.sms.SmsSender;
import com.xmall.third.constants.VerifyCodeScopeEnum;
import com.xmall.third.exception.ErrorCodeEnum;
import com.xmall.third.repository.facade.SmsRepository;
import com.xmall.third.service.SmsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zhouxufu
 */
@Service
public class SmsServiceImpl implements SmsService {


    private final SmsSender smsSender;
    private final SmsProperties smsProperties;
    private final SmsRepository smsRepository;

    public SmsServiceImpl(SmsSender smsSender,
                          SmsProperties smsProperties,
                          SmsRepository smsRepository) {
        this.smsSender = smsSender;
        this.smsProperties = smsProperties;
        this.smsRepository = smsRepository;
    }

    @Override
    public CommonResult<?> sendVerifyCode(VerifyCodeScopeEnum verifyCodeScopeEnum, String phone) {
        //生成验证码
        String verifyCode = RandomUtil.randomNumbers(6);
        //发送短信
        String templateCode = smsProperties.getTemplateCodeMap().get(verifyCodeScopeEnum.name());
        if (templateCode == null) {
            return CommonResult.error(ErrorCodeEnum.smsTemplateConfig.getErrorCode(), ErrorCodeEnum.smsTemplateConfig.getMessage());
        }
        SmsContext smsContext = new SmsContext(phone, smsProperties.getSignName(), templateCode)
                .smsBodyBuilder().addKeyValue("code", verifyCode).build();
        smsSender.sendSms(smsContext);
        //存储验证码
        smsRepository.saveVerifyCode(verifyCodeScopeEnum.name(), phone, verifyCode, 300L);
        return CommonResult.ok();
    }


    @Override
    public CommonResult<Boolean> checkVerifyCode(VerifyCodeScopeEnum verifyCodeEnum, String phone, String verifyCode) {
        String sendVerifyCode = smsRepository.getVerifyCode(verifyCodeEnum.name(), phone);
        if (StringUtils.isNotBlank(sendVerifyCode) && sendVerifyCode.equals(verifyCode)) {
            return CommonResult.ok(true);
        }
        return CommonResult.ok(false);
    }
}
