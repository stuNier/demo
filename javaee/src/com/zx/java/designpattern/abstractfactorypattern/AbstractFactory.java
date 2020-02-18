package com.zx.java.designpattern.abstractfactorypattern;


import com.zx.java.designpattern.abstractfactorypattern.color.Color;
import com.zx.java.designpattern.factorypattern.Shape;

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
public interface AbstractFactory{

    Color getColor(String colorType);

    Shape getShape(String shapeType);
}
