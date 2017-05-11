package com.miao.util;

import java.sql.*;

/**
 * Created by 10048 on 2017/5/9.
 */
public class DBConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/db_affairmanage?useSSL=true";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "12345";

    /**
     * 连接数据库
     * @return  数据库连接对象
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
        return conn;
    }

    /**
     * 关闭连接对象
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭预处理对象
     * @param pstmt
     */
    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭结果集对象
     * @param resultSet
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
