package com.zx.java.designPattern.abstractFactoryPattern;

/**
 * Title: AbstractFactoryPattern
 * Description: TODO 抽象工厂模式
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 10:46
 */
public class AbstractFactoryPattern {

    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        //获取颜色工厂
        AbstractFactory colorFactory = factoryProducer.getFactory("Color");
        colorFactory.getColor("Red").draw();
        colorFactory.getColor("Blue").draw();
        //获取形状工厂
        AbstractFactory shapeFactory = factoryProducer.getFactory("Shape");
        shapeFactory.getShape("Triangle").draw();
        shapeFactory.getShape("Circle").draw();
    }

}
