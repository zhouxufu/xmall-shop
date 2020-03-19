package com.xmall.common.core.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 用于
 * 1.服务之间返回值
 * 2.前端接口的返回值
 *
 * @author zhouxufu
 */
@Data
@Accessors(chain = true)
public class PageResult<T> {
    /**
     * 当前页数
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Long totalRows;
    /**
     * 数据列表
     */
    private List<T> dataList;
}
