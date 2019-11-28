package com.zx.java.algorithm;

import java.util.*;

/**
 * Title: SlideWindow
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/25 11:02
 */
public class SlideWindow {

    public static void main(String[] args) {
        int[] array = {2, -1, 5, -3, 4, -9, 10, -11, 2};
        System.out.println(Arrays.toString(slidWnd(array, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(array, 3)));
    }

    public static int[] slidWnd(int[] arr, int k){
        if(k>arr.length)    return null;
        Deque<Integer> slidWnd = new LinkedList<>();
        for(int i=0; i<arr.length-k; i++){

        }
        return null;
        /*int[] result = new int[arr.length-k+1];
        for(int i=0; i<arr.length-k; i++){
            int[] res = max(arr, i, i+k);
            for(int j=i; j<=res[1]; j++){
                result[j] = res[0];
            }
            i+=res[1];
        }
        return result;*/
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // 保证从大到小 如果前面数小 弹出
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if(list.peek()<=i-k){
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if(i-k+1>=0){
                result[i-k+1] = nums[list.peek()];
            }
        }
        return result;
    }

    public static int[] max(int[] arr, int start, int end){
        int tmp = arr[start], j = start;
        for(int i=start+1; i<end; i++){
            if(tmp < arr[i]) {
                j = i;
                tmp = arr[i];
            }
        }
        int[] res = new int[2];
        res[0] = tmp;
        res[1] = j;
        System.out.println(Arrays.toString(res));
        return res;
    }
}
