package com.xmall.user.exception;

import com.xmall.common.core.exception.ErrorCode;
import lombok.Getter;

/**
 * @author zhouxufu
 */
@Getter
public enum ErrorCodeEnum implements ErrorCode {


    /**
     * 系统通用错误码tar
     * 使用范围 0-99
     * 其他业务使用请使用 99+
     * 并且严格按照系统区分
     * i18n 暂不使用localeKey用于后期集成i18n扩展
     * 用户系统使用 10开头
     */
    alreadyRegister("该手机号已被注册,请直接登录", 100001, ""),
    verifyError("验证码错误", 100002, "");

    /**
     * 错误消息
     */
    private String message;
    /**
     * 错误码
     */
    private Integer errorCode;
    /**
     * 国际化资源key
     */
    private String localeKey;


    ErrorCodeEnum(String message, Integer errorCode, String localeKey) {
        this.message = message;
        this.errorCode = errorCode;
        this.localeKey = localeKey;
    }
}
