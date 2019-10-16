package com.thunisoft.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: Test
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/9/20 11:14
 */
public class Test {
    @org.junit.Test
    public void test() throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        Thread tA = new Thread(threadA,"ThreadA");
        Thread tB = new Thread(threadB,"ThreadB");
        tA.start();
        tA.join();
        tB.start();
        tB.join();
    }

    public void swap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a+","+b);
    }

    public int hammingDistance(int x, int y) {
        x = x^y;
        y = 0;
        /**
         * 0001
         * 0100
         */
        System.out.println(Integer.toBinaryString(x));
        return y;
    }
}


