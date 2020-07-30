package com.zx.demo.javaee.leetcode.单词转换;


import org.junit.Test;

import java.util.*;

/**
 * Title: Solution
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/7/30 11:44
 */
public class Solution {
    public String endWord;
    public List<String> wordList;
    public Set<String> used = new HashSet<>();
    public LinkedList<String> result = new LinkedList<>();

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        String[] wordArr = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new LinkedList<>();
        Collections.addAll(wordList, wordArr);
        for(int i=0; i<10000; i++){
           findLadders("hit", "cog", wordList).toString();
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.endWord = endWord;
        this.wordList = wordList;
        LinkedList<String> curList = new LinkedList<>();
        curList.offer(beginWord);
        used.add(beginWord);
        findLadders(curList);
        return result;
    }

    public boolean findLadders(LinkedList<String> curList) {
        if (curList.peekLast().equals(endWord)) {
            result = new LinkedList<>(curList);
            return true;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (used.contains(wordList.get(i))) {
                continue;
            }
            if (isValid(wordList.get(i), curList.peekLast())) {
                used.add(wordList.get(i));
                curList.offer(wordList.get(i));
                if (findLadders(curList)) {
                    return true;
                }
                curList.pollLast();
            }
        }
        return false;
    }

    boolean isValid(String s1, String s2) {
        int dir = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dir++;
            }
            if (dir > 1) {
                return false;
            }
        }
        return true;
    }
}
