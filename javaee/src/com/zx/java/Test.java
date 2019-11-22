package com.zx.java;

/**
 * Title: Test
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/10/30 10:36
 */
public class Test implements Runnable{
    static int i=0;

    public void increase(){
        synchronized(Test.class){
            i++;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Test());
        Thread t2 = new Thread(new Test());
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for(int i=0; i<100000; i++){
            this.increase();
        }
    }
}
