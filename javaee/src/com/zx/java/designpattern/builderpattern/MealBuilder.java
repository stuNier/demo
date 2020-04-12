package com.zx.java.designpattern.builderpattern;

import com.zx.java.designpattern.builderpattern.burger.ChickenBurger;
import com.zx.java.designpattern.builderpattern.burger.VegBurger;
import com.zx.java.designpattern.builderpattern.drink.CoffeeDrink;
import com.zx.java.designpattern.builderpattern.drink.PepsiDrink;

/**
 * Title: MealBuilder
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 13:53
 */
public class MealBuilder {
    public Meal prepareChickenMeal (){
        Meal meal = new Meal();
        meal.add(new ChickenBurger());
        meal.add(new PepsiDrink());
        return meal;
    }

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.add(new VegBurger());
        meal.add(new CoffeeDrink());
        return meal;
    }
}
