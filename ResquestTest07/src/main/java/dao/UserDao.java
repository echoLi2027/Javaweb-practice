package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;


public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User userLogin(User user) {
        try {
            String sql = "select * from user where username=? and password=?";
            User userLogin =template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
            return userLogin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
