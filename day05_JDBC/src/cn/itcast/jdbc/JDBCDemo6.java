package cn.itcast.jdbc;

import java.sql.*;

/**
 * create
 */
public class JDBCDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接对象Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db3?characterEncoding=utf8","root","123456");
            //3.获取SQL操作对象Statement
            stmt = conn.createStatement();
            //4.SQL
            String sql = "select * from account";
            //5.执行SQL
            ResultSet rs = stmt.executeQuery(sql);
            //6
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Double banance = rs.getDouble(3);
                System.out.println(id+name+banance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
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

}
