package com.zx.java.designPattern.builderPattern;

/**
 * Title: BuilderPattern
 * Description: TODO 建造者模式
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 13:48
 */
public class BuilderPattern {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        mealBuilder.prepareChickenMeal().showItems();
    }
}
