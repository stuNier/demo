package com.zx.demo.javaee.pattern.observer;

/**
 * Title: BinObserver
 * Description: 二进制
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 14:44
 */
public class BinObserver extends BaseObserver {

    public BinObserver(Subject subject){
        this.subject = subject;
        subject.add(this);
    }

    @Override
    public void update(int value) {
        this.data = Integer.toBinaryString(value);
    }
}
