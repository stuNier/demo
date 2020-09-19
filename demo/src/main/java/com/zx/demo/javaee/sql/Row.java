package com.zx.demo.javaee.sql;

import lombok.Data;

import java.io.Serializable;

/**
 * Title: Row
 * Description: Row
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/16 14:18
 */
@Data
public class Row implements Serializable {
    private String oldStr;
    private String comment;
    private String tarStr;
}
