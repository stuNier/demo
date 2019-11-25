package com.zx.java.algorithm.greedyAlgorithm;

import lombok.Data;

import java.util.Arrays;

/**
 * Title: GreedyAlgorithm
 * Description: TODO 贪心算法跳跃游戏
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/22 15:20
 */
@Data
public class GreedyAlgorithmJumpGame {

    /**
     * 位置信息
     */
    private int[] position;

    /**
     * 初始化
     */
    public GreedyAlgorithmJumpGame(int[] postition){
        this.position = postition;
    }

    /**
     * 跳跃
     */
    public boolean jump(){
        return true;
    }

    /**
     * 打印位置信息
     */
    public void print(){
        System.out.println(Arrays.toString(position));
    }

}
