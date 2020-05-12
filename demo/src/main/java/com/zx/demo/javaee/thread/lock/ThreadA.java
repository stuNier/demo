package com.zx.demo.javaee.thread.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;


/**
 * Title: Thread
 * Description: xianc
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 16:43
 */
@Slf4j
public class ThreadA implements Runnable {

    private ReentrantLock lock = new ReentrantLock();

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        print();
    }

    private void print() {
        try {
            lock.lock();
            log.info(Thread.currentThread().getName()+"锁住");
            Thread.sleep(3000);
        } catch (InterruptedException e){
          lock.equals(e.getMessage());
        } finally{
            log.info(Thread.currentThread().getName()+"释放锁");
            lock.unlock();
        }

    }
}
