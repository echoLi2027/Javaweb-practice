package jdbc;

import util.JDBCUtils;

import java.sql.*;

public class JdbcTransaction10 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement p1 = null;
        PreparedStatement p2 = null;

        try
        {
//            1. get connection
            conn = JDBCUtils.getConnection();
//            2. open transaction
            conn.setAutoCommit(false);

            String sql1 = "update bankaccount set balance = balance - ? where id = ?";
            String sql2 = "update bankaccount set balance = balance + ? where id = ?";
            p1 = conn.prepareStatement(sql1);
            p2 = conn.prepareStatement(sql2);
            p1.setInt(1, 500);
            p2.setInt(1, 500);
            p1.setInt(2,1);
            p2.setInt(2,2);
            p1.executeUpdate();
            p2.executeUpdate();

            conn.commit();


        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }finally {
                JDBCUtils.close(p1,conn);
                JDBCUtils.close(p2,conn);
            }
        }

    }

}

