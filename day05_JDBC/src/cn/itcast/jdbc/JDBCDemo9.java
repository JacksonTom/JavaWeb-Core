package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo9 {

    public static void main(String[] args) {
        //1.键盘录入，接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //2.调用方法
        boolean flag = new JDBCDemo9().login2(username, password);
        //3.判断结果，输出不同语句
        if(flag){
            //登录成功
            System.out.println("登录成功！");
        }else{
            System.out.println("用户名或密码错误！");
        }


    }

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password){
        if(username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "Select * from user where username = '"+username+"' and password = '"+password+"' ";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        //出现异常则返回false
        return false;
    }

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public boolean login2(String username, String password){
        if(username == null || password == null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "Select * from user where username = ? and password = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"username");
            pstmt.setString(2,"password");
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        //出现异常则返回false
        return false;
    }
}
