package com.zx.demo.javaee.pattern.observer;

import org.junit.Test;

/**
 * Title: ObserverPatternTest
 * Description: 观察者模式测试类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 14:52
 */
public class ObserverPatternTest {

    @Test
    public void test(){
        Subject subject = new Subject();
        new BinObserver(subject);
        new OctObserver(subject);
        new HexObserver(subject);
        subject.setStatus(10);
        subject.print();
        subject.setStatus(15);
        subject.print();
    }

}
