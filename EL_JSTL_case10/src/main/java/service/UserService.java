package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

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

    /**
     * add user from browser data
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * delete user by id
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * find user by id
     * @param i
     * @return
     */
    User findUserById(int i);

    /**
     * update user
     * @param user
     */
    void updateUser(User user);


    PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition);
}
