package jdbc;

import java.sql.*;

public class JdbcShowQuery06 {

    public static void main(String[] args) {

        Statement stat = null;
        Connection conn = null;
        ResultSet rs = null;
//        1. import driver package
//        2. register driver

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            3.get db connection obj
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");
//        4.define sql sentence
            String sql = "select * from bankaccount";
//        5. get statement obj which can execute sql obj
            stat = conn.createStatement();
//        6.execute sql sentence
            rs = stat.executeQuery(sql);
//        7.process result
//            7.1 let mouse move to next line
            rs.next();
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double balance = rs.getDouble("balance");

            System.out.println(id + " " + name + " " + balance);

            rs.next();
            int id1 = rs.getInt(1);
            String name1 = rs.getString("name");
            double balance1 = rs.getDouble("balance");

            System.out.println(id1 + " " + name1 + " " + balance1);

            rs.next();
            int id2 = rs.getInt(1);
            String name2 = rs.getString("name");
            double balance2 = rs.getDouble("balance");

            System.out.println(id2 + " " + name2 + " " + balance2);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

//        8.release resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}

