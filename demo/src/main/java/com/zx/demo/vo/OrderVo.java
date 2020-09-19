package com.zx.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Title: OrderVo
 * Description: OrderVo
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 18:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {

    /**
     * userid
     */
    private int userId;

    /**
     * bookid
     */
    private int bookId;

    /**
     * 数量
     */
    private int number;
}
