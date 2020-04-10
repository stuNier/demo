package com.zx.demo.javaee.core.collection;

/**
 * TreeSet示例
 */
public class  StudentSetDemo implements Comparable {

    private int id;

    public StudentSetDemo(int id){
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof StudentSetDemo){
            return this.id - ((StudentSetDemo)o).getId();
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
