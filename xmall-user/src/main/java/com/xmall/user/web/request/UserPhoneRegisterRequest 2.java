package com.xmall.user.web.request;

import lombok.Data;

/**
 * @author zhouxufu
 */
@Data
public class UserPhoneRegisterRequest {

    private String phone;

    private String verifyCode;
}
