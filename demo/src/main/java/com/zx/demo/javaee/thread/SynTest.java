package com.zx.demo.javaee.thread;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Title: SynTest
 * Description: Synchronized测试类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 9:53
 */
@Slf4j
public class SynTest {

    @Getter
    private int count;

    public SynTest(){
        this.count = 0;
    }

    public void reduce(){
        log.info("--"+Integer.toString(count));
        this.count--;
        log.info("--"+Integer.toString(count));
    }

    public synchronized void add(){
        log.info("++"+Integer.toString(count));
        this.count++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("++"+Integer.toString(count));
    }

}
