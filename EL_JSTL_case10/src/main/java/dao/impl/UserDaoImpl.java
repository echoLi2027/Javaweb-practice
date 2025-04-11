package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import service.UserService;
import util.JDBCUtils;

import java.util.*;

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
        template.update(sql, user.getName(), user.getAge(), user.getGender(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {

        String sql = "select count(*) from user where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);

        Set<String> keys = condition.keySet();

        ArrayList<Object> keyValues = new ArrayList<>();

        for (String key : keys) {

            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            String value = condition.get(key)[0];

            if (value!=null && !"".equals(value)) {
                sb.append(" and " + key + " like ? ");
                keyValues.add("%"+value+"%");
            }

        }

        sql = sb.toString();

        System.out.println(sql);
        for (Object keyValue : keyValues) {
            System.out.println(keyValue);
        }

        return template.queryForObject(sql, Integer.class, keyValues.toArray());


    }

    @Override
    public List<User> findByPage(int startRow, int rows, Map<String, String[]> condition) {

//        1. 1st ? is the starting index, 2nd ? is the query length(from the start point) going to get.
        String sql = "select * from user where 1=1 ";

        StringBuilder sb = new StringBuilder(sql);

//        2. traverse map collection
        Set<String> keys = condition.keySet();

//        2.1 define the param list for search value
        List<Object> values = new ArrayList<>();

        for (String key : keys) {

//            expel this 2 params
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

//            get value of key(attr input from webpage)
            String val = condition.get(key)[0];
//            check if val has value
            if (val!=null && !"".equals(val)) {
                sb.append(" and "+key+ " like ? ");
                values.add("%"+val+"%");
            }
        }

//        3. last append page query
        sb.append(" limit ?, ?");

//        4. add page query params into value list
        values.add(startRow);
        values.add(rows);
        sql = sb.toString();
        System.out.println("total count sql:"+sql);
        System.out.println(values);

        return template.query(sql, new BeanPropertyRowMapper<>(User.class), values.toArray());





//        not good, high risks for SQL injection
        /*
        if (condition==null || condition.isEmpty()) {
            sql.append("select * from user where 1 = 1 ");
        }else{
            sql.append("select * from user where 1 = 1 ");
            if (condition.containsKey("name") && condition.get("name")[0] != null && !condition.get("name")[0].isEmpty()) {
                sql.append(" and name like '%"+condition.get("name")[0]+"%' ");
            }
            if (condition.containsKey("address") && condition.get("address")[0] != null && !condition.get("address")[0].isEmpty()) {
                sql.append(" and address like '%"+condition.get("address")[0]+"%' ");
            }
            if (condition.containsKey("email") && condition.get("email")[0] != null && !condition.get("email")[0].isEmpty()) {
                sql.append(" and email like '%"+condition.get("email")[0]+"%' ");
            }
        }
        sql.append(" limit ?, ?");



        System.out.println("total count sql:"+sql);

        List<User> userList = template.query(sql.toString(), new BeanPropertyRowMapper<>(User.class), startRow, rows);
        return userList;*/
    }


}
