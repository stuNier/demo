package com.zx.java.algorithm;

import com.zx.java.algorithm.greedyAlgorithm.GreedyAlgorithmJumpGame;

import java.util.*;

/**
 * Title: AlgorithmTest
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/22 15:21
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] str = reader.nextLine().split("\\s+");
        int[] position = new int[str.length];

        try{
            for(int i=0; i<position.length; i++){
                position[i] = Integer.parseInt(str[i]);
            }
        }catch (NumberFormatException e){
            System.out.print("input error...");
            return;
        }
        GreedyAlgorithmJumpGame game = new GreedyAlgorithmJumpGame(position);
        game.print();
        System.out.print(game.jump());
    }
}
