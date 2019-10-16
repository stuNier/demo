package com.thunisoft.demo.bean.thread;

import com.thunisoft.demo.common.GlobalValue;

/**
 * Title: ThreadB
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/10/8 14:47
 */
public class ThreadB implements Runnable {

    @Override
    public void run() {
        System.out.println("ThreadB run:");
        for(int i = 0; i<1000; i++){
            System.out.print("-");
            GlobalValue.threadVar = "ThreadB";
        }
        System.out.println("\nThreadB end!");
    }
}
