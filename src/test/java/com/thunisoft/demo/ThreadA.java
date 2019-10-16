package com.thunisoft.demo;

/**
 * Title: ThreadA
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/10/8 14:43
 */
public class ThreadA implements Runnable{

    @Override
    public void run() {
        System.out.println("ThreadA run:");
        for(int i=0; i<100; i++){
            System.out.print(".");
        }
        System.out.println("\nThreadA end!");
    }
}
