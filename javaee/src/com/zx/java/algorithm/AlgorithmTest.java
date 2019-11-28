package com.zx.java.algorithm;

import com.zx.java.algorithm.greedyAlgorithm.GreedyAlgorithmJumpGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static Logger logger = LoggerFactory.getLogger(AlgorithmTest.class);


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] str = reader.nextLine().split("\\s+");
        int[] position = new int[str.length];

        try{
            for(int i=0; i<position.length; i++){
                position[i] = Integer.parseInt(str[i]);
            }
        }catch (NumberFormatException e){
            logger.info("input error...");
            return;
        }
        GreedyAlgorithmJumpGame game = new GreedyAlgorithmJumpGame(position);
        game.print();
    }
}
