package com.xmall.user.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xmall.common.core.response.CommonResult;
import com.xmall.common.core.sentinel.DefaultBlock;
import com.xmall.common.core.sentinel.DefaultFallback;
import com.xmall.third.constants.VerifyCodeScopeEnum;
import com.xmall.third.service.SmsService;
import com.xmall.user.dto.UserPhoneRegisterDTO;
import com.xmall.user.exception.ErrorCodeEnum;
import com.xmall.user.repository.facade.UserAccountRepository;
import com.xmall.user.repository.po.UserAccount;
import com.xmall.user.service.UserRegisterService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

/**
 * 用户注册service
 *
 * @author zhouxufu
 */
@Service(protocol = "dubbo", version = "1.0")

@RefreshScope
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserAccountRepository userAccountRepository;
    @Reference(version = "1.0")
    private final SmsService smsService;

    public UserRegisterServiceImpl(UserAccountRepository userAccountRepository,
                                   SmsService smsService) {
        this.userAccountRepository = userAccountRepository;
        this.smsService = smsService;
    }

    @SentinelResource(
            //资源名称，用与熔断、降级、限流
            value = "registerByPhone",
            //默认降级类
            fallbackClass = DefaultFallback.class,
            //降级方法，必须是静态方法
            fallback = "defaultFallback",
            //限流后执行的类
            blockHandlerClass = DefaultBlock.class,
            //限流后执行方法名
            blockHandler = "defaultBlock"
    )
    @Override
    public CommonResult<?> registerByPhone(UserPhoneRegisterDTO userPhoneRegisterDTO) {
        String phone = userPhoneRegisterDTO.getPhone();
        boolean exists = userAccountRepository.phoneExists(phone);
        if (exists) {
            return CommonResult.error(ErrorCodeEnum.alreadyRegister);
        }
        CommonResult<Boolean> checkVerifyCode = smsService.checkVerifyCode(VerifyCodeScopeEnum.register, phone, userPhoneRegisterDTO.getVerifyCode());
        if (!checkVerifyCode.isSuccess()) {
            //调用方根据需要是否抛出异常
            checkVerifyCode.throwRpcException();
        }
        Boolean verifyIsTrue = checkVerifyCode.getData();
        if (!verifyIsTrue) {
            return CommonResult.error(ErrorCodeEnum.verifyError);
        }
        UserAccount userAccount = generateUserAccount(userPhoneRegisterDTO.getPhone(), userPhoneRegisterDTO.getPassword());
        //入库
        userAccountRepository.registerByPhone(userAccount);
        return CommonResult.ok();
    }

    private UserAccount generateUserAccount(String phone, String password) {
        LocalDateTime now = LocalDateTime.now();
        UserAccount userAccount = new UserAccount();
        userAccount.setPhone(phone);
        userAccount.setPassword(new BCryptPasswordEncoder().encode(password));
        userAccount.setStatus(UserAccount.ENABLE_STATUS);
        userAccount.setGmtCreate(now);
        userAccount.setGmtModified(now);
        return userAccount;
    }
}
