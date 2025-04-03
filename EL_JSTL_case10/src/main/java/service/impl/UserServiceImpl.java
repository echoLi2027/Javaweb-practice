package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
