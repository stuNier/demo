package com.thunisoft.demo.bean.thread;

import com.thunisoft.demo.common.GlobalValue;
import org.springframework.context.annotation.Bean;

/**
 * Title: ThreadA
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/10/8 14:43
 */
public class ThreadA implements Runnable{

    @Override
    public void run() {
        System.out.println("ThreadA run:");
        for(int i=0; i<1000; i++){
            System.out.print(".");
            GlobalValue.threadVar = "ThreadA";
        }
        System.out.println("\nThreadA end!");
    }
}
