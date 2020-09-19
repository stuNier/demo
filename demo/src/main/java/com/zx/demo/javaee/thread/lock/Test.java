package com.zx.demo.javaee.thread.lock;

/**
 * Title: Test
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 16:52
 */
public class Test {

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        Thread threadA = new Thread(a,"a");
        Thread threadB = new Thread(a,"b");
        threadA.start();
        threadB.start();
    }
}
