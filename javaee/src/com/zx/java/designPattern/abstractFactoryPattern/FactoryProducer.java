package com.zx.java.designPattern.abstractFactoryPattern;

import com.zx.java.designPattern.abstractFactoryPattern.color.ColorFactory;
import com.zx.java.designPattern.factoryPattern.ShapeFactory;

/**
 * Title: FactoryProducer
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 10:54
 */
public class FactoryProducer {

    public  AbstractFactory getFactory(String factoryType){
        switch (factoryType){
            case "Color": return new ColorFactory();
            case "Shape": return new ShapeFactory();
            default: return null;
        }
    }
}
