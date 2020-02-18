package com.zx.java.designpattern.singletonpattern;

/**
 * Title: SingletonObject
 * Description: TODO 单例类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 11:17
 */
public class SingletonObject {

    private static SingletonObject instance;

    private SingletonObject(){
        //私有化构造方法 使得类不能被实例化
    }

    /**
     * 多线程双检锁
     * 只有在单例未初始化的时候才需要初始化单例，这时才需要加锁
     * @return 单例
     */
    public static SingletonObject getInstance(){
        if(null==instance){
            synchronized (SingletonObject.class){
                if(null==instance){
                    instance = new SingletonObject();
                }
            }
        }
        return instance;
    }
}
