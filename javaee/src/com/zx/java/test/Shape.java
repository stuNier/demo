package com.zx.java.test;

import lombok.Data;

/**
 * Title: Shape
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2019/12/16 17:15
 */
@Data
public class Shape {
    private String message;
    public String getShape(){
        return "shape";
    }
}
