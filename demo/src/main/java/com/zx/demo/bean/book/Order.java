package com.zx.demo.bean.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Title: Order
 * Description: order
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 17:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * 主键
     */
    private int id;

    /**
     * userid
     */
    private int userId;

    /**
     * bookid
     */
    private int bookId;

    /**
     * 单价
     */
    private double unitPrice;

    /**
     * 数量
     */
    private int number;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态
     */
    private String status;
}
