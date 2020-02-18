package com.zx.java.designpattern.prototypepattern.shape;

/**
 * Title: Shape
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 14:57
 */
public abstract class Shape implements Cloneable {

    private String name;

    public abstract void draw();

    public void setName(String _name){
        name = _name;
    }

    public String getName(){
        return name;
    }

    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }
}
