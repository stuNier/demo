package com.zx.java.designPattern.factoryPattern;

/**
 * Title: FactoryPattern
 * Description: TODO 工厂模式
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 10:31
 */
public class FactoryPattern {

    /**
     * 只需要从工厂取货，而不必知道货物是怎样生成出来的（每一次新增一种产品，都需要新增类并修改工厂获取方法）
     */
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("Circle").draw();
        shapeFactory.getShape("Circle").draw();
        shapeFactory.getShape("Square").draw();
        shapeFactory.getShape("Circle").draw();
    }
}
