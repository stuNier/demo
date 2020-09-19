package com.zx.demo.javaee.pattern.strategy;

import org.junit.Test;

/**
 * Title: StrategyPatternTest
 * Description: StrategyPatternTest
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 11:48
 */
public class StrategyPatternTest {

    @Test
    public void test(){
        StrategyPattern strategyPattern = new StrategyPattern(new Benz());
        strategyPattern.excute();
        strategyPattern = new StrategyPattern(new Ford());
        strategyPattern.excute();
    }

}
