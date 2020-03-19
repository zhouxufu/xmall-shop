package com.xmall.common.core.exception;

/**
 * 业务异常类，业务异常请抛出此异常，但是需要注意以下几点
 * 1.业务异常将有统一的异常处理类进行处理，无需自己处理
 * 2.所有业务异常通常不会回滚数据库操作
 * 3.业务异常不应该触发降级，所以在配置降级的时候请排除业务异常
 * 4.抛出业务异常时请注意业务异常的errorCode 的唯一性 方便后续维护
 * 5.请保证业务描述信息尽可能友好，方便前端的展示
 * <p>
 * feature 这里的异常消息后续可以添加国际化
 *
 * @author zhouxufu
 */
public class BusinessException extends RuntimeException {
    /**
     * 业务异常编码
     */
    private Integer errorCode;
    /**
     * 业务异常信息
     */
    private String message;

    public BusinessException(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
