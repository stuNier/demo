package com.zx.java.designPattern.factoryPattern;

/**
 * Title: Square
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 10:37
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
