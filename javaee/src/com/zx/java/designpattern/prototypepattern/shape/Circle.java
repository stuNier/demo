package com.zx.java.designpattern.prototypepattern.shape;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: Circle
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 15:05
 */
@Slf4j
public class Circle extends Shape {

    @Override
    public void draw() {
        log.info("Circle");
    }
}
