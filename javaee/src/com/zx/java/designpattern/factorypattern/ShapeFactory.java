package com.zx.java.designpattern.factorypattern;

import com.zx.java.designpattern.abstractfactorypattern.AbstractFactory;
import com.zx.java.designpattern.abstractfactorypattern.color.Color;

/**
 * Title: ShapeFactory
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 10:38
 */
public class ShapeFactory implements AbstractFactory {

    @Override
    public Color getColor(String colorType) {
        return null;
    }

    /**
     * 工厂获取
     * @param shapeType shape类型
     * @return
     */
    @Override
    public Shape getShape(String shapeType){
        switch (shapeType){
            case "Circle": return new Circle();
            case "Square": return new Square();
            case "Triangle": return new Triangle();
            default: return null;
        }
    }
}
