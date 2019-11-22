package com.zx.demo.bean.thread;

import com.zx.demo.common.GlobalValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private Logger logger = LoggerFactory.getLogger(ThreadA.class);

    @Override
    public void run() {
        logger.info("ThreadA run:");
        for(int i=0; i<1000; i++){
            logger.info(".");
            GlobalValue.theadVar = "ThreadA";
        }
        logger.info("\nThreadA end!");
    }
}
