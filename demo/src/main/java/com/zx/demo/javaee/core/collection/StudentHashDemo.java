package com.zx.demo.javaee.core.collection;

/**
 * hash示例
 */
public class StudentHashDemo{
    private int id;

    public StudentHashDemo(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof StudentHashDemo){
            if(((StudentHashDemo) obj).getId() == this.getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
