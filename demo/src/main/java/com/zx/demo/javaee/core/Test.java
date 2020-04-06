package com.zx.demo.javaee.core;

/**
 * Title: Test
 * Description: CoreTest
 *
 * @author 2957145040@qq.com
 * @version 1.0
 * date 2020/4/5 19:12
 */
public class Test {

    public static void main(String[] args) {
        short a = 1;
        System.out.println(a);
        a = (short) (a+1);
        System.out.println(a);
        String str = "str";
        byte b = 2;
        switch (b){
            case 1 :
                System.out.println("1");
                break;
            case 2 :
                System.out.println("2");
                break;
            case 3 :
                System.out.println("3");
                break;
                default:
                    System.out.println("none");
        }
    }
}
