package com.zx.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Title: Demo
 * Description: demo测试实体
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/14 14:34
 */
@Data
public class Demo implements Serializable {

    /**
     * 主键
     */
    private int id;

    /**
     * 描述
     */
    private String des;
}
