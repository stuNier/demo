package com.zx.demo.javaee.pattern.single;


/**
 * Title: Single
 * Description: 设计模式-单例模式
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 10:37
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton(){

    }

    /**
     * 双检锁获取单例
     * @return Singleton
     */
    public static Singleton getSingleton(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
