package com.zx.demo.javaee.leetcode.删除空格;

import org.junit.Test;

/**
 * Title: 删除空格
 * Description: 删除空格
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/7/31 14:17
 */
public class 删除空格 {
    /**
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
     * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
     * 在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
     * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     * 注意：本题相对原题稍作改动，只需返回未识别的字符数
     * 示例：
     * 输入：
     * dictionary = ["looked","just","like","her","brother"]
     * sentence = "jesslookedjustliketimherbrother"
     * 输出： 7
     * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
     * 提示：
     * 0 <= len(sentence) <= 1000
     * dictionary中总字符数不超过 150000。
     * 你可以认为dictionary和sentence中只包含小写字母。
     */

    @Test
    public void test() {
        String[] dictionary = {"brother","looked", "just", "like", "her"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(breakSentence(sentence, dictionary));
    }

    /**
     * 断句
     *
     * @param sentence   文章
     * @param dictionary 字典
     * @return 未识别字数
     */
    public int breakSentence(String sentence, String[] dictionary) {
        int wordNum = sentence.length();
        for (String word : dictionary) {
            wordNum = addPlace(sentence, wordNum, word);
        }
        return wordNum;
    }

    /**
     * 添加空格
     *
     * @param sentence sentence
     * @param wordNum  wordNum
     * @param word     word
     * @return 剩余未匹配字数
     */
    private int addPlace(String sentence, int wordNum, String word) {
        boolean already = false;
        for (int i = 0; i < sentence.length(); i++) {
            if (' ' == sentence.charAt(i)) {
                already = !already;
            }
            if (already) {
                continue;
            }
            int startIndex = i;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == sentence.charAt(i)) {
                    i++;
                    continue;
                }
                break;
            }
            if(startIndex + word.length() > i){
                continue;
            }
            wordNum = wordNum - word.length();
            sentence = sentence.substring(0, startIndex) + " " + word + " " + sentence.substring(startIndex + word.length());
            i++;
        }
        return wordNum;
    }

}
