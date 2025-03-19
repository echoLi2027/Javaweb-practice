package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectedDS_01 {

    public static void main(String[] args) {

         try {
             Properties pro = new Properties();
             InputStream rs = ConnectedDS_01.class.getClassLoader().getResourceAsStream("druid.properties");
             pro.load(rs);
             DataSource ds = DruidDataSourceFactory.createDataSource(pro);
             Connection conn = ds.getConnection();
             System.out.println(conn);

         }  catch (Exception e) {
             throw new RuntimeException(e);
         }
    }

}
