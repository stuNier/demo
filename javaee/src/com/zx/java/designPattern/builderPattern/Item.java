package com.zx.java.designPattern.builderPattern;

import com.zx.java.designPattern.builderPattern.packing.Packing;

/**
 * Title: Item
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 14:02
 */
public interface Item {
    //TODO 食物条目

    /**
     * 获取食物名称
     * @return 名称
     */
    String getName();

    /**
     * 打包
     * @return 打包方式
     */
    Packing packing();

    /**
     * 获取食物价格
     * @return 价格
     */
    float getPrice();
}
