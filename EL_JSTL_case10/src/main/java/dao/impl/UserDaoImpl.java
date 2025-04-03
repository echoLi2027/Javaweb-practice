package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import service.UserService;
import util.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;


    }

    @Override
    public User login(String username, String password) {
        try {
            String sql = "select* from user where username=? and password=?";

            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            // login fail
            return null;
        } catch (Exception e) {
            // other exception
            throw new RuntimeException(e);
        }
    }
}
