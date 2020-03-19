package com.xmall.third.constants;

/**
 * @author zhouxufu
 */

public enum VerifyCodeScopeEnum {
    /**
     * 短信验证码枚举
     */
    register("注册验证码"),
    bind("绑定手机号"),

    ;

    VerifyCodeScopeEnum(String desc) {
        this.desc = desc;
    }

    private String desc;

}
