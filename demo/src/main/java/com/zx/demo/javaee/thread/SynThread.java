package com.zx.demo.javaee.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: SynThread
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 9:57
 */
@Slf4j
public class SynThread implements Runnable {

    private SynTest synTest;

    private static int WAIT_TIME = 3000;

    /**
     * 构造
     *
     * @param synTest synTest
     * @return void
     * @author: zhengxin-3@thunisoft.com
     * date: 20-05-12 10:00
     * @version 1.0
     */
    public SynThread(SynTest synTest) {
        this.synTest = synTest;
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
        synTest.add();
//        log.info(Integer.toString(synTest.getCount()));
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        synTest.reduce();
//        log.info(Integer.toString(synTest.getCount()));
    }


}
