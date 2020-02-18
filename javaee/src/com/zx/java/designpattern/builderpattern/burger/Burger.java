package com.zx.java.designpattern.builderpattern.burger;

import com.zx.java.designpattern.builderpattern.Item;
import com.zx.java.designpattern.builderpattern.packing.Packing;
import com.zx.java.designpattern.builderpattern.packing.Wrapper;

/**
 * Title: Burger
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 13:56
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
