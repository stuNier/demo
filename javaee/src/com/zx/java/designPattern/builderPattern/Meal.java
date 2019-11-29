package com.zx.java.designPattern.builderPattern;

import com.zx.java.designPattern.builderPattern.packing.Packing;

import java.util.ArrayList;

/**
 * Title: Meal
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 14:19
 */
public class Meal {
    //TODO 订单
    private ArrayList<Item> items;

    public Meal(){
        items = new ArrayList<>();
    }

    /**
     * 添加商品
     * @param item 商品
     */
    public void add(Item item){
        items.add(item);
    }

    /**
     * 消费金额
     * @return 金额
     */
    public double cost(){
        double cost = 0;
        for(Item item:items){
            cost+=item.getPrice();
        }
        return cost;
    }

    /**
     * 打印凭条
     */
    public void showItems(){
        for(Item item:items){
            System.out.println("name: " + item.getName() + "\tprice: " + item.getPrice());
        }
        System.out.print("cost: " + cost());
    }
}
