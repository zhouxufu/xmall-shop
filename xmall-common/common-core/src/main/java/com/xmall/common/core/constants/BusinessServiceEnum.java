package com.xmall.common.core.constants;

import lombok.Getter;

/**
 * 业务系统枚举
 *
 * @author zhouxufu
 */
public enum BusinessServiceEnum {
    /**
     *
     */
    gateway("10", "网关系统"),
    user("20", "用户系统"),
    item("30", "商品系统"),
    order("40", "订单系统"),
    pay("50", "支付系统"),
    search("60", "搜索系统"),
    third("70", "第三方系统");

    @Getter
    private String serviceCode;

    @Getter
    private String serviceDesc;

    BusinessServiceEnum(String serviceCode, String serviceDesc) {
        this.serviceCode = serviceCode;
        this.serviceDesc = serviceDesc;
    }
}
