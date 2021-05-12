package com.classTest.JDBC;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/12 14:51
 * @Version 1.0
 */

public class JDBCUntils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
    *文件的读取，只需要使用一次即可拿到这些值
    */

    static{
        try {
            Properties pro = new Properties();
            ClassLoader classloader = JDBCUntils.class.getClassLoader();
            URL res = classloader.getResource("jdbc.properties");
            String path = res.getPath();
            pro.load(new FileReader(path));

            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }


    public static void close(Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
