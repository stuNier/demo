package com.zx.demo.javaee.pattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: Subject
 * Description: Subject
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 14:32
 */
public class Subject {

    private List<Observer> observers;

    public Subject(){
        observers = new LinkedList<>();
    }

    public void update(int value){
        for(Observer observer:observers){
            observer.update(value);
        }
    }

    public void setStatus(int value){
        update(value);
    }

    public void add(Observer observer){
        observers.add(observer);
    }

    public void print(){
        for(Observer observer:observers){
            observer.print();
        }
    }

}
