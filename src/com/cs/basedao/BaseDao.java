package com.cs.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //创建数据库连接对象方法
    public Connection getConn() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workdb?useUnicode=true&characterEncoding=utf-8"
                , "root", "114514");
        return conn;
    }

    //查询方法
    public ResultSet execQuery(String sql, Object... objects) throws Exception {
        getConn();
        ps = conn.prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
        }
        rs = ps.executeQuery();
        return rs;
    }

    //增删改方法
    public int execUpdate(String sql, Object... objects) throws Exception {
        getConn();
        int index = -1;
        ps = conn.prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1,objects[i]);
            }
        }
        index = ps.executeUpdate();
        return index;
    }

    //关闭资源方法
    public void getClose() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
