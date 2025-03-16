package jdbc;

import domain.Emp;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JdbcLogInCheck09 {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input username:");
        String username = scanner.nextLine();
        System.out.println("please input password:");
        String password = scanner.nextLine();
        JdbcLogInCheck09 obj = new JdbcLogInCheck09();
        boolean flag = obj.checkLogin2(username, password);
        if (flag) {
            System.out.println("log in success!");
        }else {
            System.out.println("username or password incorrect!");
        }

    }

    public boolean checkLogin(String username, String password){

        if (username==null || password==null) {
            return false;
        }

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where name='"+username+"' and password='"+password+"'";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(rs,stat,conn);
        }

//        return false;
    }

    public boolean checkLogin2(String username, String password){

        if (username==null || password==null) {
            return false;
        }

        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where name = ? and password = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,username);
            pstat.setString(2,password);
            rs = pstat.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(rs,pstat,conn);
//            return false;
        }
    }





}

