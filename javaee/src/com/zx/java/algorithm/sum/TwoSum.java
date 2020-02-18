package com.zx.java.algorithm.sum;

import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: TwoSum
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/1/16 15:37
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        print(twoSum(nums));
    }

    /**
     *
     * @param nums 数据列表
     * @return 结果
     */
    public static List<List<Integer>> twoSum(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length&&nums[i]<0; i++){
            for(int j=nums.length-1; j>=0&&nums[j]>0; j--){
                if(nums[i]+nums[j]==0){
                    List<Integer> res = new LinkedList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    result.add(res);
                }
            }
        }
        return result;
    }

    /**
     * 打印
     * @param list list
     */
    public static void print(List<List<Integer>> list){
        if(null==list || list.isEmpty()) {
            System.out.println("list is empty!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (List<Integer> li:list){
            sb.append("\t[");
            for(Integer data: li){
                sb.append(data);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]\n");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}
