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
    public int addUser(User user) {
        String sql = "insert into user (name,gender,age,address,qq,email) values(?,?,?,?,?,?)";
        int updated = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return updated;
    }

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

    @Override
    public int deleteUser(Integer id) {
        String sql = "delete from user where id=?";
        return template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?, age = ?, gender = ?, address = ?, qq = ?, email = ? where id = ?";

        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getGender());
        System.out.println(user.getAddress());
        System.out.println(user.getQq());
        System.out.println(user.getEmail());
        System.out.println(user.getId());
        template.update(sql, user.getName(), user.getAge(), user.getGender(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }
}
