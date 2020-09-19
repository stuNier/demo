package com.zx.demo.javaee.leetcode.婴儿名字;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 婴儿名字
 * Description: 婴儿名字
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/7/30 19:24
 */
public class 婴儿名字 {
    /**
     * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，
     * 例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。
     * 设计一个算法打印出每个真实名字的实际频率。
     * 注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
     * 在结果列表中，选择字典序最小的名字作为真实名字。
     * 示例：
     * 输入：
     * names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
     * synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
     * 输出：["John(27)","Chris(36)"]
     * 提示：
     * names.length <= 100000
     */

    /**
     * 测试入口
     */
    @Test
    public void test() {
        String[] names = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        countNames(names, synonyms);
    }

    /**
     * 计算婴儿名字
     *
     * @param names    names
     * @param synonyms synonyms
     */
    public void countNames(String[] names, String[] synonyms) {
        Integer[] num = new Integer[names.length];
        for (int i = 0; i < names.length; i++) {
            int startIndex = names[i].indexOf("(");
            int endIndex = names[i].indexOf(")");
            num[i] = Integer.parseInt(names[i].substring(startIndex + 1, endIndex));
            names[i] = replace(synonyms, names[i].substring(0, startIndex));
        }
        ArrayList<String> nameRes = new ArrayList<>();
        ArrayList<Integer> numRes = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            int index = nameRes.indexOf(names[i]);
            if (index >= 0 && index < numRes.size()) {
                numRes.set(index, numRes.get(index) + num[i]);
                continue;
            }
            nameRes.add(names[i]);
            numRes.add(num[i]);
        }
        List<String> result = new LinkedList<>();
        for (int i = 0; i < nameRes.size(); i++) {
            result.add(nameRes.get(i) + "(" + numRes.get(i) + ")");
        }
        System.out.println(result.toString());
    }

    /**
     * 用字典替换
     *
     * @param synonyms synonyms
     * @param name     name
     * @return 替换值
     */
    private String replace(String[] synonyms, String name) {
        String result = name;
        for (String synonym : synonyms) {
            if (synonym.endsWith(name + ")")) {
                String nextName = replace(synonyms, synonym.substring(1, synonym.indexOf(",")));
                if (null != nextName) {
                    result = nextName;
                }
            }
        }
        return result;
    }
}
