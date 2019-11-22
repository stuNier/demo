package com.zx.java.thread.countdownlacth;


import java.util.concurrent.CountDownLatch;

/**
 * Title: RacerTest
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/10/30 11:06
 */
public class RacerTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Racer racerA = new Racer(countDownLatch, "racerA");
        Racer racerB = new Racer(countDownLatch, "racerB");
        Racer racerC = new Racer(countDownLatch, "ThreadC");
        new Thread(racerA).start();
        new Thread(racerB).start();
        new Thread(racerC).start();
        Thread.sleep(1000);
        for(int i=3; i>0; i--){
            System.out.println(i);
            if(i==1)
                System.out.println("start.....................................");
            countDownLatch.countDown();
            Thread.sleep(1000);
        }
    }
}
