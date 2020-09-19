package com.zx.demo.javaee.pattern.strategy;

/**
 * Title: StrategyPattern
 * Description: 策略模式
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 11:47
 */
public class StrategyPattern {

    private Car car;

    public StrategyPattern(Car car){
        this.car = car;
    }

    public void excute(){
        car.start();
    }
}
