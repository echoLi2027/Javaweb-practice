package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public int addUser(User user) {

        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User findUserById(int i) {
        return userDao.findById(i);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition) {
        PageBean<User> pageBean = new PageBean<>();

//        1.set known attrs to bean obj
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

//        2.get totalCount from dao
        int totalCount = userDao.findTotalCount(condition);

        System.out.println("totalCount:"+totalCount);

        pageBean.setTotalCount(totalCount);
//        3. get total page from total count and rows
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;


//        3.1 if already in the last page and request for go next page
        if (currentPage >= totalPage) {
            currentPage = totalPage;
        }

        System.out.println("currentPage:"+currentPage);

        pageBean.setTotalPage(totalPage);
//        4. get current page's starting index
        int startRow = (currentPage - 1) * rows;

        System.out.println("startRow:"+startRow);

//        5. get current page user list to display
        List<User> userList = userDao.findByPage(startRow, rows, condition);

        pageBean.setList(userList);

        return pageBean;
    }
}
