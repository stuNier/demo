package com.zx.demo.javaee.core.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Title: JdbcDemo
 * Description: JdbcDemo
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/14 11:19
 */
public class JdbcTest {

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        usePreparedStatement();
        System.out.println(System.currentTimeMillis()-start);
        /*start = System.currentTimeMillis();
        callStored();
        System.out.println(System.currentTimeMillis()-start);*/

    }

    public void callStored(){
        String connectStr = "jdbc:mysql://172.25.8.133:3306/demo?serverTimezone=UTC";
        String sql = "call proc_ins_copy(?,?)";
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectStr, "root", "123456");
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall(sql);
            for(int i=0; i<100000; i++){
                callableStatement.setInt(1, i);
                callableStatement.setString(2, "des");
                callableStatement.addBatch();
            }
            callableStatement.executeBatch();
            connection.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!=connection){
                try {
                    connection.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if(null!=callableStatement){
                try {
                    callableStatement.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }


    }

    public void usePreparedStatement(){
        String connectStr = "jdbc:mysql://172.25.8.133:3306/demo?serverTimezone=UTC";
        String sql = "insert into demo.demo (id,des) values (?,?)";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectStr, "root", "123456");
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            for(int i=0; i<100000; i++){
                ps.setInt(1, i);
                ps.setString(2, "des");
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            if(null!=connection){
                try {
                    connection.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if(null!=ps){
                try {
                    ps.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
