package com.classTest.JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName CP30demo
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/12 15:55
 * @Version 1.0
 */

public class CP30demo {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();


        for (int i = 1 ;i<=10;i++){
            Connection conn = ds.getConnection();
            System.out.println(i + ":"+conn);
        }

    }

}
