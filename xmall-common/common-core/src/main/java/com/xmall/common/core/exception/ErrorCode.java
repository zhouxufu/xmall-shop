package com.xmall.common.core.exception;

/**
 * @author zhouxufu
 */
public interface ErrorCode {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    public abstract Integer getErrorCode();

    /**
     * 获取错误消息
     *
     * @return 错误消息
     */
    public abstract String getMessage();

    /**
     * 获取本地化key
     *
     * @return 本地化key
     */
    public abstract String getLocaleKey();


}
