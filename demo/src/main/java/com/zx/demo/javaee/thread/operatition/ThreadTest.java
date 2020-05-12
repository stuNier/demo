package com.zx.demo.javaee.thread.operatition;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * Title: ThreadTest
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 16:11
 */
public class ThreadTest {

    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(1);
        A a = new A(semaphore);
        B b = new B(semaphore);
        C c = new C(semaphore);
        Thread threadA = new Thread(a, "a");
        Thread threadB = new Thread(b, "b");
        Thread threadC = new Thread(c, "c");
        threadA.start();
        threadB.start();
        threadC.start();
    }


    @Test
    public void orderTest() {
        ThreadA a = new ThreadA();
        Thread threadA = new Thread(a, "ThreadA");
        Thread threadB = new Thread(a, "ThreadB");
        threadA.start();
        threadB.start();
    }

}
