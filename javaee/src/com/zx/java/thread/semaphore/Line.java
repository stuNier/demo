package com.zx.java.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Title: Line
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/10/31 15:51
 */
public class Line {

    private Semaphore a;

    private Thread[] line;

    Line(){
        a = new Semaphore(1);
        line = new Thread[3];
        line[0] = new Thread(new Person("PersonA"));
        line[1] = new Thread(new Person("PersonB"));
        line[2] = new Thread(new Person("PersonC"));
    }

    public void printA() throws InterruptedException {
        a.acquire();
        line[0].start();
        a.release();
        a = new Semaphore(2);
    }

    public void printB() throws InterruptedException {
        a.acquire(2);
        line[1].start();
        a.release(2);
        a = new Semaphore(3);
    }

    public void printC() throws InterruptedException {
        a.acquire(3);
        line[2].start();
        a.release(3);
    }

    public void start(String order) throws InterruptedException {
        for(int i=0; i<3; i++){
            switch(order.charAt(i)){
                case 'A': printA();break;
                case 'B': printB();break;
                case 'C': printC();break;
            }
        }
    }

}
