package com.zx.demo.javaee.leetcode.最短超串;

import org.junit.Test;

import java.util.Arrays;

/**
 * Title: 最短超串
 * Description: 最短超串
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/7/30 14:30
 */
public class 最短超串 {
    /**
     * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
     * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
     * 示例 1:
     * 输入:
     * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
     * small = [1,5,9]
     * 输出: [7,10]
     * 示例 2:
     * 输入:
     * big = [1,2,3]
     * small = [4]
     * 输出: []
     * 提示：
     * big.length <= 100000
     * 1 <= small.length <= 100000
     */
    private int[] bigArr;
    private int[] smallArr;

    /**
     * 测试方法入口
     */
    @Test
    public void test() {
        int[] bigArr = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] smallArr = {1, 5, 9,};
        getStr(bigArr, smallArr);
    }

    /**
     * 获取超串
     *
     * @param bigArr   bigArr
     * @param smallArr smallArr
     */
    public void getStr(int[] bigArr, int[] smallArr) {
        this.bigArr = bigArr;
        this.smallArr = smallArr;
        int start = 0;
        int end = 0;
        int step = 0;
        int minLength = bigArr.length;
        int[] result = new int[2];
        for (int i = 0; i < bigArr.length; i++) {
            if (isInSmall(bigArr[i], step)) {
                if (step == 0) {
                    start = i;
                }
                step++;
            }
            if (step == smallArr.length) {
                end = i;
//                System.out.println(Arrays.toString(smallArr));
//                System.out.println("[" + start + "," + end + "]");
                if (minLength > end - start) {
                    minLength = end - start;
                    result[0] = start;
                    result[1] = end;
                }
                step = 0;
                start = 0;
            }
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * 判断num是否在smallArr中
     *
     * @param num  num
     * @param step step
     * @return boolean
     */
    private boolean isInSmall(int num, int step) {
        for (int i = 0; i < smallArr.length; i++) {
            if (smallArr[i] == num) {
                smallArr[i] = smallArr[step];
                smallArr[step] = num;
                return true;
            }
        }
        return false;
    }

}
