package com.zx.java.designpattern.builderpattern.drink;

import com.zx.java.designpattern.builderpattern.Item;
import com.zx.java.designpattern.builderpattern.packing.Bottle;
import com.zx.java.designpattern.builderpattern.packing.Packing;

/**
 * Title: ColdDrink
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 13:59
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
