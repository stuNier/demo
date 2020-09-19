package com.zx.demo.javaee.thread.operatition;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * Title: A
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 16:26
 */
@Slf4j
public class C implements Runnable{

    private Semaphore semaphore;

    public C(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print() throws InterruptedException{
        semaphore.acquire(3);
        log.info(Thread.currentThread().getName()+"开始");
        Thread.sleep(3000);
        log.info(Thread.currentThread().getName()+"结束");
        semaphore.release();
    }
}