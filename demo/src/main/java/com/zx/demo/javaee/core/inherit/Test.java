package com.zx.demo.javaee.core.inherit;


/**
 * Title: Test
 * Description: 测试类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/7 17:21
 */
public class Test {

    @org.junit.Test
    public void tes1() {
        Children children = new Children();
    }

    @org.junit.Test
    public void test2(){
        Cat cat = new Cat();
        Dog dog = new Dog();
        run(dog);
        run(cat);
    }

    public void run(BaseAnimal animal){
        animal.run();
    }

    @org.junit.Test
    public void test3(){

    }
}
