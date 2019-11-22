package com.zx.java.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Title: Person
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/10/31 15:31
 */
public class Person implements Runnable{

    private String name;

    @Override
    public void run() {
        System.out.println(getName()+":start...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(getName()+":over");
    }

    public Person() {
        name = "null";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
