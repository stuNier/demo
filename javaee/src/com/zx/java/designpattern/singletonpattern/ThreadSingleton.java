package com.zx.java.designpattern.singletonpattern;

/**
 * Title: ThreadSingleton
 * Description: TODO 多线程下的单例模式
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 11:38
 */
public class ThreadSingleton implements Runnable{

    @Override
    public void run() {
        SingletonObject singletonObject = SingletonObject.getInstance();
    }
}
