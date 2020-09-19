package com.zx.demo.javaee.leetcode.单词转换;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 单词转换
 * Description: 单词转换
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/7/30 10:13
 */
public class 单词转换 {
    /**
     * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
     * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
     * 示例 1:
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * 输出:
     * ["hit","hot","dot","lot","log","cog"]
     * 示例 2:
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * 输出: []
     * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
     */
    private List<String> wordList = new LinkedList<>();

    private LinkedList<String> stepList = new LinkedList<>();

    public 单词转换(List<String> wordList) {
        this.wordList = wordList;
    }


    /**
     * 测试入口
     */
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        String startWord = "hit";
        String endWord = "cog";
        Collections.addAll(this.wordList, wordList);
        turn(startWord, endWord);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    /**
     * 转换
     *
     * @param startWord 需要转换的word
     * @param endWord   转换后的word
     */
    public LinkedList turn(String startWord, String endWord) {
        if (startWord.length() != endWord.length()) {
            return stepList;
        }
        //endWord不在字典中
        if (!isInWordList(endWord)) {
            return stepList;
        }
        turn(startWord, endWord, wordList);
        stepList.offerFirst(startWord);
        return stepList;
    }

    /**
     * 转换
     *
     * @param startWord startWord
     * @param endWord   endWord
     * @param wordList  wordList
     * @return boolean
     */
    public boolean turn(String startWord, String endWord, List<String> wordList) {
        List<String> nextWordList = new LinkedList<>(wordList);
        for (String word : wordList) {
            if (startWord.equals(endWord)) {
                return true;
            }
            if (getStep(startWord, word) == 1) {
                startWord = word;
                nextWordList.remove(word);
                if (turn(startWord, endWord, nextWordList)) {
                    stepList.offerFirst(startWord);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否包含在wordList字典中
     *
     * @param word 单词
     * @return boolean
     */
    private boolean isInWordList(String word) {
        for (String str : wordList) {
            if (str.equals(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取步长
     *
     * @param startWord startWord
     * @param endWord   endWord
     * @return 步长
     */
    private int getStep(String startWord, String endWord) {
        if (startWord.length() != endWord.length()) {
            return -1;
        }
        int step = 3;
        for (int i = 0; i < startWord.length(); i++) {
            if (startWord.charAt(i) == endWord.charAt(i)) {
                step--;
            }
        }
        return step;
    }

}
