package com.xmall.user.web.controller;

import com.xmall.common.core.response.CommonResult;
import com.xmall.user.dto.UserPhoneRegisterDTO;
import com.xmall.user.service.UserRegisterService;
import com.xmall.user.web.convert.UserRegisterConverter;
import com.xmall.user.web.request.UserPhoneRegisterRequest;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxufu
 */
@RestController
@Api(tags = "用户注册")
public class UserRegisterController {
    /**
     * 思考： 用户分为，用户主表，用户微信表，
     */
    @Reference
    private UserRegisterService userRegisterService;

    @PostMapping("/user/phone")
    public CommonResult<?> registerByPhone      (@RequestBody UserPhoneRegisterRequest userPhoneRegisterRequest) {
//        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        UserPhoneRegisterDTO userPhoneRegisterDTO = UserRegisterConverter.INSTANCE.requestToDTO(userPhoneRegisterRequest);
        return userRegisterService.registerByPhone(userPhoneRegisterDTO);
    }
}
