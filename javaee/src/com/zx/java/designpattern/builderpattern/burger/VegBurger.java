package com.zx.java.designpattern.builderpattern.burger;

/**
 * Title: VegBurger
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 13:57
 */
public class VegBurger extends Burger{
    //TODO 蔬菜堡

    @Override
    public String getName() {
        return "VegBurger";
    }

    @Override
    public float getPrice() {
        return 12.00f;
    }
}
