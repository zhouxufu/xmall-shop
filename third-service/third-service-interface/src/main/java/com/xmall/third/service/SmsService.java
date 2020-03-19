package com.xmall.third.service;

import com.xmall.common.core.response.CommonResult;
import com.xmall.third.constants.VerifyCodeScopeEnum;

/**
 * 验证码服务
 *
 * @author zhouxufu
 */
public interface SmsService {

    /**
     * 发送验证码
     *
     * @param verifyCodeEnum 验证码类型
     * @param phone          手机号
     * @return 公共返回值
     */
    CommonResult<?> sendVerifyCode(VerifyCodeScopeEnum verifyCodeEnum, String phone);

    /**
     * 检验验证码
     *
     * @param verifyCodeEnum
     * @param phone
     * @param verifyCode
     * @return
     */
    CommonResult<Boolean> checkVerifyCode(VerifyCodeScopeEnum verifyCodeEnum, String phone, String verifyCode);


}
