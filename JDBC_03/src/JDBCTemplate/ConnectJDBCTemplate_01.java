package JDBCTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidJDBCUtils;

import javax.sql.DataSource;

public class ConnectJDBCTemplate_01 {

    static DataSource ds = null;

    public static void main(String[] args) {
        ds = DruidJDBCUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        int updated = template.update("update bankaccount set balance = 6000 where name = ?", "sheldon");
        System.out.println(updated);

    }
}
