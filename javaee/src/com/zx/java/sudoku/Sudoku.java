package com.zx.java.sudoku;

/**
 * Title: Sudoku
 * Description: TODO 数独
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/22 11:17
 */
public class Sudoku {

    /**
     * 数独棋盘数组
     */
    private byte[][] sudoku;

    /**
     * 无参构造函数
     */
    public Sudoku(){
        init();
    }

    /**
     * 初始化
     */
    public void init(){
        sudoku = new byte[9][9];
        for(int i=0; i<sudoku.length; i++){
            for(int j=0; j<sudoku[i].length; j++){

            }
        }
    }

    /**
     * 解数独
     */
    public void solution(){
    }

    private byte getRandom(){
        return  1;
    }

    /**
     * 打印数独
     */
    public void print(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<sudoku.length; i++) {
            if(i!=0 && i%3==0)
                sb.append("-  -  -   -  -  -   -  -  -\n");
            for(int j=0; j<sudoku[i].length; j++){
                if(0!=j && j%3==0)
                    sb.append(" | ");
                else if(j!=0)
                    sb.append("  ");
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
