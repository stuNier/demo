package com.zx.java.designPattern.singletonPattern;

/**
 * Title: SingletonPattern
 * Description: TODO 单例模式
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 11:15
 */
public class SingletonPattern {

    /**
     * 单例模式只能有一个实例
     * 单例类只能自己创建一个实例
     * 单例类只能给其他对象返回唯一的实例
     */
    public static void main(String[] args) {

        Thread[] threads = new Thread[100];
        for(int i=0; i<100; i++){
            threads[i] = new Thread(new ThreadSingleton());
        }
        for(int i=0; i<100; i++){
            threads[i].start();
        }
    }
}
