package dao;

import domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User login(String username, String password);
}
