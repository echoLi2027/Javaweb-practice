package service;

import domain.User;

import java.util.List;

public interface UserService {

    /**
     * find all users
     * @return
     */
    List<User> findAll();

    /**
     * login check by username and password
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
