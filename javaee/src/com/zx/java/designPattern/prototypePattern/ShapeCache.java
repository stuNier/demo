package com.zx.java.designPattern.prototypePattern;

import com.zx.java.designPattern.prototypePattern.shape.Circle;
import com.zx.java.designPattern.prototypePattern.shape.Shape;
import com.zx.java.designPattern.prototypePattern.shape.Square;
import com.zx.java.designPattern.prototypePattern.shape.Trigger;

import java.util.Hashtable;

/**
 * Title: ShapeCache
 * Description: TODO 模拟数据库
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 15:08
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeName) {
        Shape cachedShape = shapeMap.get(shapeName);
        if(null==cachedShape)
            return null;
        return (Shape)cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setName("Circle");
        shapeMap.put(circle.getName(),circle);

        Square square = new Square();
        square.setName("Square");
        shapeMap.put(square.getName(),square);

        Trigger trigger = new Trigger();
        trigger.setName("Triangle");
        shapeMap.put(trigger.getName(),trigger);
    }

}
