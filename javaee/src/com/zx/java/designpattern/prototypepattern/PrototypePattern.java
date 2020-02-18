package com.zx.java.designpattern.prototypepattern;


import com.zx.java.designpattern.prototypepattern.shape.Shape;

/**
 * Title: PrototypePattern
 * Description: TODO 原型模式
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 14:38
 */
public class PrototypePattern {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("Circle");
        System.out.println("Shape : " + clonedShape.getName());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("Square");
        System.out.println("Shape : " + clonedShape2.getName());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("Triangle");
        System.out.println("Shape : " + clonedShape3.getName());
    }
}
