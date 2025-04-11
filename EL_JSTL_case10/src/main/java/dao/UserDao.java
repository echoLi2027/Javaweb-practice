package dao;

import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    int addUser(User user);

    List<User> findAll();

    User login(String username, String password);

    int deleteUser(Integer id);

    User findById(int id);

    void updateUser(User user);

    /**
     * find all count in user table
     */
    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int startRow, int rows, Map<String, String[]> condition);
}
