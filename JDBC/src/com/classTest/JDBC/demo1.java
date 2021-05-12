package com.classTest.JDBC;

import com.classTest.JDBC.JDBCUntils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ClassName demo1
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/12 15:33
 * @Version 1.0
 */

public class demo1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        boolean flag = demo1.login(username,password);

        if(flag){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或密码错误");
        }
    }

    public static boolean login(String username,String password){
        if(username == null || password == null){
            return false;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = JDBCUntils.getConnection();

            String sql = "select * from admin where username = ? and password = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,username);
            pstmt.setString(2,password);

            rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUntils.close(rs,pstmt,conn);
        }

        return false;

    }
}
