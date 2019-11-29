package com.zx.java.designPattern.abstractFactoryPattern.color;

import com.zx.java.designPattern.abstractFactoryPattern.AbstractFactory;
import com.zx.java.designPattern.factoryPattern.Shape;

/**
 * Title: ColorFactory
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 11:00
 */
public class ColorFactory implements AbstractFactory {

    @Override
    public Color getColor(String colorType){
        switch (colorType) {
            case "Red": return new Red();
            case "Blue": return new Blue();
            case "Green": return new Green();
            default:return null;
        }
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
