package com.zx.demo.bean.book;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Title: Book
 * Description: book
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 13:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    /**
     * 主键
     */
    private int id;

    /**
     * 名称
     */
    @Excel(name = "name")
    private String name;

    /**
     * 描述
     */
    @Excel(name = "address")
    private String address;

    /**
     * 价格
     */
    @Excel(name = "price")
    private double price;

    /**
     * 数量
     */
    @Excel(name = "number")
    private int number;
}
