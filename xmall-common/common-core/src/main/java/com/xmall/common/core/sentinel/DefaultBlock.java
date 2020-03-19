package com.xmall.common.core.sentinel;

import com.xmall.common.core.response.CommonResult;

import static com.xmall.common.core.exception.SystemErrorCodeEnum.block;

/**
 * sentinel fallback 默认实现
 * 触发降级
 *
 * @author zhouxufu
 */
public class DefaultBlock {

    public static CommonResult<?> defaultBlock() {
        return CommonResult.error(block.getErrorCode(), block.getMessage());
    }

}
