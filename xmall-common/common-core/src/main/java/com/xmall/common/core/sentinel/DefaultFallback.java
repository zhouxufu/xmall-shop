package com.xmall.common.core.sentinel;

import com.xmall.common.core.response.CommonResult;

import static com.xmall.common.core.exception.SystemErrorCodeEnum.fallback;

/**
 * sentinel fallback 默认实现
 * 触发降级
 *
 * @author zhouxufu
 */
public class DefaultFallback {

    public static CommonResult<?> defaultFallback() {
        return CommonResult.error(fallback.getErrorCode(), fallback.getMessage());
    }

}
