package com.xmall.user.service;

import com.xmall.common.core.response.CommonResult;
import com.xmall.user.dto.UserPhoneRegisterDTO;

/**
 * @author zhouxufu
 */
public interface UserRegisterService {


    /**
     * 用户通过手机号进行注册
     *
     * @param userPhoneRegisterDTO
     * return
     */
    CommonResult<?> registerByPhone(UserPhoneRegisterDTO userPhoneRegisterDTO);
}
