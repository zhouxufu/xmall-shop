package com.xmall.common.core.response;

import com.xmall.common.core.exception.ErrorCode;
import com.xmall.common.core.exception.RpcException;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 用于
 * 1.服务之间返回值
 *
 * @author zhouxufu
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    private static final int SUCCESS_CODE = 0;

    /**
     * 构造成功返回值
     *
     * @param data 返回数据
     * @param <T>  返回值泛型
     * @return
     */
    public static <T> CommonResult<T> ok(T data) {
        return new CommonResult<T>().setCode(0).setData(data);
    }

    /**
     * 构造成功返回值
     *
     * @param <T> 返回值泛型
     * @return
     */
    public static <T> CommonResult<T> ok() {
        return ok(null);
    }

    /**
     * 失败返回值
     *
     * @param errorCode 错误码
     * @param message   错误信息
     * @param <T>       返回值泛型
     * @return
     */
    public static <T> CommonResult<T> error(Integer errorCode, String message) {
        return new CommonResult<T>().setCode(errorCode).setMessage(message);
    }

    /**
     * 失败返回值
     *
     * @param errorCode 错误码
     * @param <T>       返回值泛型
     * @return
     */
    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        return error(errorCode.getErrorCode(), errorCode.getMessage());
    }

    /**
     * @return 是否成功
     */
    public Boolean isSuccess() {
        return SUCCESS_CODE == code;
    }

    /**
     * 抛出Rpc调用异常
     */
    public void throwRpcException() {
        throw new RpcException();
    }

}
