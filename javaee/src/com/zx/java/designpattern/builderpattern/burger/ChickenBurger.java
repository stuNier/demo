package com.zx.java.designpattern.builderpattern.burger;

/**
 * Title: ChickenBurger
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 13:58
 */
public class ChickenBurger extends Burger{
    //TODO 鸡肉堡

    @Override
    public String getName() {
        return "ChickenBurger";
    }

    @Override
    public float getPrice() {
        return 15.0f;
    }
}
