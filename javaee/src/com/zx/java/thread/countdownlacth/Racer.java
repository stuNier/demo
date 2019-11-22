package com.zx.java.thread.countdownlacth;

import java.util.concurrent.CountDownLatch;

/**
 * Title: Racer
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/10/31 13:46
 */
public class Racer implements Runnable{

    private String name;

    private CountDownLatch countDownLatch;

    Racer(){
    }

    /**
     * @param countDownLatch racer countDownLatch
     * @param name racer name
     */
    Racer(CountDownLatch countDownLatch, String name){
        super();
        setName(name);
        setCountDownLatch(countDownLatch);
    }

    @Override
    public void run(){
        System.out.println(getName() + " is waiting....");
        int k = 0;
        try {
            countDownLatch.await();
            System.out.println(getName()+":running!!!");
            Thread.sleep((int)(0+Math.random()*(10000-1+0)));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }finally {
            System.out.println(getName()+":arriving!!!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
