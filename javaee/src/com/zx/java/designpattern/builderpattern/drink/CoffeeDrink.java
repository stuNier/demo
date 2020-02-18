package com.zx.java.designpattern.builderpattern.drink;

/**
 * Title: CoffeeDrink
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 14:00
 */
public class CoffeeDrink extends ColdDrink {
    //TODO 咖啡

    @Override
    public String getName() {
        return "Coffee";
    }

    @Override
    public float getPrice() {
        return 12.00f;
    }
}
