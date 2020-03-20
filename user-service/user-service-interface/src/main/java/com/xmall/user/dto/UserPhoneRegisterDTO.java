package com.xmall.user.dto;

import lombok.Data;

@Data
public class UserPhoneRegisterDTO {

    private String phone;

    private String password;

    private String verifyCode;
}
