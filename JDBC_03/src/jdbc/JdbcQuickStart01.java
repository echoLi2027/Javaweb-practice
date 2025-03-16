package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcQuickStart01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1. import driver package
//        2. register driver
        Class.forName("com.mysql.cj.jdbc.Driver");

//        3.get db connection obj
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");
//        4.define sql sentence
        String sql = "update bankaccount set balance = 3000";
//        5. get statement obj which can execute sql obj
        Statement stat = conn.createStatement();
//        6.execute sql sentence
        int count = stat.executeUpdate(sql);
//        7.process result
        System.out.println(count);
//        8.release resources
        stat.close();
        conn.close();

    }
}

/*
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcQuickStart01 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Use the newer driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Update connection URL with necessary parameters for MySQL 8
            String url = "jdbc:mysql://localhost:3306/myproject";

            // 3. Get connection (using try-with-resources for better resource management)
            conn = DriverManager.getConnection(url, "root", "root");

            // 4. Create and execute SQL statement
            String sql = "update bankaccount set balance = 2000";
            stmt = conn.createStatement();

            // 5. Use executeUpdate for UPDATE statements
            int rowsAffected = stmt.executeUpdate(sql);

            // 6. Process result
            System.out.println("Rows updated: " + rowsAffected);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error:");
            e.printStackTrace();
        } finally {
            // 7. Close resources in finally block
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/
