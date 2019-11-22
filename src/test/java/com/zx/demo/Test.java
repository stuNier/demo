package com.zx.demo;

import java.util.Scanner;

/**
 * Title: Test
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/9/20 11:14
 */
public class Test {

    public static void main(String[] args) {
        Board board = new Board();
        board.csh(25,25);
        board.bz(200);
        /*for(int k=0; k<board.m; k++){
            for(int l=0; l<board.n; l++){
                System.out.print(board.board[0][k][l]+"  ");
            }
            System.out.println();
        }*/
        Scanner input = new Scanner(System.in);
        int i, j, command;
        //输入命令
        while (input.hasNext()){
            i = input.nextInt();
            j = input.nextInt();
            command = input.nextInt();
            if(i>=board.m || j>=board.n || i<0 || j<0){
                System.out.println("越界");
                continue;
            }
            if(command == 0){
                if(board.board[1][i][j]=="O"){
                    if(board.board[0][i][j]=="*"){
                        System.out.println("---------------");
                        System.out.println(" ");
                        for(int k=0; k<board.m; k++){
                            if(k<10){
                                System.out.print(k+" |");
                            }else{
                                System.out.print(k+"|");
                            }
                            for(int l=0; l<board.n; l++){
                                System.out.print(board.board[0][k][l]+"  ");
                            }
                            System.out.println();
                        }
                        /**
                         * 重置
                         */
                        System.out.println("dead!\n--------reset--------\nrestart");
                        board.cz();
                        continue;
                    }else{
                        board.zk(i, j);
                    }
                }
            }else if(command == 1){
                if(!board.kill(i, j)){
                    System.out.println("无效操作");
                }
            }else if(command == 999){
                for(int k=0; k<board.m; k++){
                    for(int l=0; l<board.n; l++){
                        System.out.print(board.board[0][k][l]+"  ");
                    }
                    System.out.println();
                }
                return;
            }

            for(i=0; i<board.m; i++){
                for(j=0; j<board.n; j++){
                    System.out.print(board.board[1][i][j]+"  ");
                }
                System.out.println();
            }
        }


        input.close();

    }


}


