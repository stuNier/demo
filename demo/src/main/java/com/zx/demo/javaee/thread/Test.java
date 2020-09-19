package com.zx.demo.javaee.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;

/**
 * Title: sql
 * Description: test
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/1 15:13
 */
@Slf4j
public class Test {

    @Autowired
    Condition condition;

    @Autowired
    Semaphore semaphore;

    /**
     * test
     *
     * @return void
     * @author: zhengxin-3@thunisoft.com
     * date: 20-05-12 9:51
     * @version 1.0
     */
    @org.junit.Test
    public void test() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            semaphore.release();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SynTest syn = new SynTest();
        SynThread synThread = new SynThread(syn);
        Thread thread = new Thread(synThread);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        syn.reduce();
    }
}
