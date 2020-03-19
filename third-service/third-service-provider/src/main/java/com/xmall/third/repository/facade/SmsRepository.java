package com.xmall.third.repository.facade;

/**
 * @author zhouxufu
 */
public interface SmsRepository {

    /**
     * 保存验证码
     *
     * @param verifyScope  验证码作用域
     * @param phone        手机号
     * @param verifyCode   验证码
     * @param expireSecond 过期时间：秒
     */
    void saveVerifyCode(String verifyScope, String phone, String verifyCode, Long expireSecond);


    /**
     * 获取验证码
     *
     * @param verifyScope 验证码作用域
     * @param phone       手机号
     */
    String getVerifyCode(String verifyScope, String phone);
}
