package com.zx.demo;

/**
 * Title: Board
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * @date 2019/10/24 14:45
 */
public class Board {

    private String name;

    public String[][][] board;

    public int[] square;

    public int sn;

    public int m;

    public int n;

    private int sl;

    public Board() {
    }

    public Board(String _name) {
        name = _name;
    }

    public void csh(){
        board = new String[2][m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[0][i][j] = "+";
                board[1][i][j] = "O";
            }
        }
        square = new int[m*n];
        for (int i = 0; i<square.length; i++){
            square[i] = i;
        }
        sn = m*n;
    }

    public void csh(int _m, int _n){
        m = _m;
        n = _n;
        csh();
    }

    public void bz(int num){
        sl = num;
        for(int i=0; i<num; i++){
            int rand = (int)(0+Math.random()*(sn-1+0));
            board[0][square[rand]/n][square[rand]%n] = "*";
            int tmp = square[sn-1];
            square[sn-1] = square[rand];
            square[rand] = tmp;
            sn--;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[0][i][j]!="*")
                    board[0][i][j] = count(i,j);
            }
        }
    }

    private String count(int i, int j){
        int count = 0;
        for(int ii=i-1; ii<=i+1; ii++){
            for(int jj=j-1; jj<=j+1; jj++){
                if(ii<0 || ii>=m || jj<0 || jj>=n || (ii==i && jj==j))
                    continue;
                if(board[0][ii][jj] == "*")
                    count++;
            }
        }
        if (count == 0)
            return "+";
        return ""+count;
    }

    public  void zk(int i, int j){
        if(i<0 || i>=m || j<0 || j>=m)
            return;
        if(board[1][i][j]!="O" || board[0][i][j]=="*")
            return;
        board[1][i][j] = board[0][i][j];
        zk(i-1, j);
        zk(i+1, j);
        zk(i, j-1);
        zk(i, j+1);
    }

    public boolean kill(int i, int j){
        if(board[1][i][j]=="O"){
            if(board[0][i][j]=="*"){
                board[1][i][j] = "-";
                return true;
            }
            return false;
        }
        return false;
    }

    public void cz(){
        csh(m, n);
        bz(sl);
    }
}
