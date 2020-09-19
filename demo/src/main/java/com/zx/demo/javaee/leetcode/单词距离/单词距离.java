package com.zx.demo.javaee.leetcode.单词距离;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 单词距离
 * Description: 单词距离
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/7/30 15:33
 */
public class 单词距离 {
    /**
     * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
     * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
     * 示例：
     * 输入：
     * words = ["I","am","a","student","from","a","university","in","a","city"],
     * word1 = "a",
     * word2 = "student"
     * 输出：1
     * 提示：
     * words.length <= 100000
     */

    /**
     * 测试入口
     */
    @Test
    public void test() {
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "a";
        String word2 = "student";
        System.out.println(getDistance(words, word1, word2));
    }

    /**
     * 获取距离
     *
     * @param words words
     * @param word1 word1
     * @param word2 word2
     * @return 最短距离
     */
    public int getDistance(String[] words, String word1, String word2) {
        int dis = words.length;
        List<Integer> word1Dis = getIndex(words, word1);
        List<Integer> word2Dis = getIndex(words, word2);
        for (int index1 : word1Dis) {
            for (int index2 : word2Dis) {
                int n = Math.abs(index2 - index1);
                if (n < dis) {
                    dis = n;
                }
            }
        }
        return dis;
    }

    /**
     * 获取word在words中的index
     *
     * @param words words
     * @param word  word
     * @return index
     */
    public List<Integer> getIndex(String[] words, String word) {
        List<Integer> dis = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                dis.add(i);
            }
        }
        return dis;
    }

}
