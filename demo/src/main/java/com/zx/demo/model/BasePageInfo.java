package com.zx.demo.model;

import lombok.Data;

/**
 * Title: BasePageInfo
 * Description: BasePageInfo
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 15:05
 */
@Data
public class BasePageInfo {
    /**
     * 页码
     */
    protected int pageNum;

    /**
     * 分页大小
     */
    protected String pageSize;

    /**
     * 数据总量
     */
    protected Long total;

    /**
     * 是否第一页
     */
    protected boolean isFirstPage;

    /**
     * 是否最后页
     */
    protected boolean isLastPage;
}
