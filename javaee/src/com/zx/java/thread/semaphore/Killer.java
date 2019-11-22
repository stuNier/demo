package com.zx.java.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Title: Killer
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/10/31 14:51
 */
public class Killer implements Runnable{

    private Semaphore knife;

    private String name;

    @Override
    public void run() {
        System.out.println("killer "+getName()+" waiting...");
        int n = (int)(1+Math.random()*(10-1+1));
        try {
            Thread.sleep(1000);
            knife.acquire();
            System.out.println(getName()+" start!!!");
            for(int i=1; i<=n; i++){
                System.out.println(getName()+":kill "+i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.out.println(getName()+" finished");
        knife.release();
    }

    public Killer() {
    }

    public Killer(Semaphore knife, String name) {
        super();
        setKnife(knife);
        setName(name);
    }

    public Semaphore getKnife() {
        return knife;
    }

    public void setKnife(Semaphore knife) {
        this.knife = knife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
