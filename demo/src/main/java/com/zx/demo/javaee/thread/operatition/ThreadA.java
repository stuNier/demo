package com.zx.demo.javaee.thread.operatition;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * Title: ThreadA
 * Description: 线程
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 16:07
 */
@Slf4j
public class ThreadA implements Runnable{

    private int i = 0;

    private Semaphore semaphore;

    public ThreadA(){
        semaphore = new Semaphore(1);
    }

    public synchronized int jiajiai(){
        i = i+1;
        return i;
    }

    public synchronized int ijiajia(){
        int temp = i;
        i = i+1;
        return temp;
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
            semaphore.acquire(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0; i<100; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            jiajiai();
        }
        log.info(Thread.currentThread().getName()+":"+Integer.toString(this.i));
        semaphore.release();
    }
}
