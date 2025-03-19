package druid;

import util.DruidJDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectedDS_02 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstat = null;
        try {
             conn = DruidJDBCUtils.getConnection();
            String sql = "update bankaccount set balance = 5000 where id = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1,1);
            int i = pstat.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DruidJDBCUtils.close(conn,pstat);
        }


    }

}
