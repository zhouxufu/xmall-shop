package com.xmall.third.exception;

import com.xmall.common.core.constants.BusinessServiceEnum;
import lombok.Getter;

/**
 * @author zhouxufu
 */
@Getter
public enum ErrorCodeEnum {


    /**
     * 系统通用错误码
     * 使用范围 0-99
     * 其他业务使用请使用 99+
     * 并且严格按照系统区分
     * i18n 暂不使用localeKey用于后期集成i18n扩展
     */
    smsTemplateConfig("短信模板未配置", Integer.valueOf(ErrorCodeEnum.SERVICE.getServiceCode() + "0001"), ""),
    ;

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

    private static BusinessServiceEnum SERVICE = BusinessServiceEnum.third;

    ErrorCodeEnum(String message, Integer errorCode, String localeKey) {
        this.message = message;
        this.errorCode = errorCode;
        this.localeKey = localeKey;
    }
}
