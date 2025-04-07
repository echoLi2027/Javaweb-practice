package dao;

import domain.User;

import java.util.List;

public interface UserDao {

    int addUser(User user);

    List<User> findAll();

    User login(String username, String password);

    int deleteUser(Integer id);
}
