package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource ds;

    static {
         try {
             /*Properties pro = new Properties();
             InputStream resource = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
             pro.load(resource);
             ds = DruidDataSourceFactory.createDataSource(pro);*/

             Properties pro = new Properties();
             pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
             ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }


    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
