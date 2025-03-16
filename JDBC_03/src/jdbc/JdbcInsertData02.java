package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertData02 {

    public static void main(String[] args) {

        Statement stat = null;
        Connection conn = null;
//        1. import driver package
//        2. register driver

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            3.get db connection obj
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");
//        4.define sql sentence
            String sql = "insert into bankaccount values(null, 'Amy', 3000)";
//        5. get statement obj which can execute sql obj
            stat = conn.createStatement();
//        6.execute sql sentence
            int count = stat.executeUpdate(sql);
//        7.process result
            System.out.println(count);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

//        8.release resources
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

