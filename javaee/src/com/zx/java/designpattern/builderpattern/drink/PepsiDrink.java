package com.zx.java.designpattern.builderpattern.drink;

/**
 * Title: Pepsi
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 14:00
 */
public class PepsiDrink extends ColdDrink {
    //TODO 可乐

    @Override
    public String getName() {
        return "Pepsi";
    }

    @Override
    public float getPrice() {
        return 8.00f;
    }
}
