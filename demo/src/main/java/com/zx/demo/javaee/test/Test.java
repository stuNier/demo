package com.zx.demo.javaee.test;

import sun.misc.Queue;

import java.util.HashMap;
import java.util.Stack;

/**
 * Title: Test
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/21 9:40
 */
public class Test {

    public static void main(String[] args) {
        String str = "1+2*(3+4)";
        String str1 = "1*2+3*(3+4)";
        String str2 = "1+2*(3+4)";
        String str3 = "1+2*(3+4)";
        String str4 = "1+2*(3+4)";
        System.out.println(toAfter(str1));
//        "(1+4)*3+10/5"
    }


    public static String toAfter(String str) {
        Stack<String> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (')' == str.charAt(i)) {
                while (!"(".equals(opStack.peek())) {
                    String op = opStack.pop();
                    String b = numStack.pop();
                    String a = numStack.pop();
                    numStack.push(a + b + op);
                }
                opStack.pop();
            } else if (Character.isDigit(str.charAt(i))) {
                if (!opStack.isEmpty() && "*".equals(opStack.peek())) {
                    String op = opStack.pop();
                    String b = str.substring(i, i + 1);
                    String a = numStack.pop();
                    numStack.push(a + b + op);
                } else {
                    numStack.push(str.substring(i, i + 1));
                }
            } else {
                opStack.push(str.substring(i, i + 1));
            }
        }
        while (!opStack.isEmpty()){
            String a = numStack.pop();
            String b = numStack.pop();
            String op = opStack.pop();
            numStack.push(b+a+op);
        }
        return numStack.pop();
    }
}
