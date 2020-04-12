package com.zx.java.designpattern.factorypattern;

/**
 * Title: Triangle
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 10:38
 */
public class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
