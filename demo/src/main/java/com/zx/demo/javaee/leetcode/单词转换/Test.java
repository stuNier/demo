package com.zx.demo.javaee.leetcode.单词转换;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: Test
 * Description: 单词转换性能测试
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/7/30 14:02
 */
public class Test {

    public static void main(String[] args) {
        /** 所需时间更短 理论空间消耗更大 */
        my();
        so();
    }

    public static void so(){
        long startTime = System.currentTimeMillis();
        String[] wordArr = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new LinkedList<>();
        Collections.addAll(wordList, wordArr);
        for(int i=0; i<10000; i++){
            Solution solution = new Solution();
            solution.findLadders("hit", "cog", wordList).toString();
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static void my(){
        long startTime = System.currentTimeMillis();
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        String startWord = "hit";
        String endWord = "cog";
        List<String> wordList1 = new LinkedList<>();
        Collections.addAll(wordList1, wordList);
        for(int i=0;i<10000; i++){
            单词转换 test = new 单词转换(wordList1);
            test.turn(startWord, endWord);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

}
