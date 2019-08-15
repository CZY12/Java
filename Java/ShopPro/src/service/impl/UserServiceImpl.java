package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.Page;
import entity.User;
import service.UserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/10 16:42
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUserNameExits(String username) {
        return userDao.checkUserExits(username);
    }

    @Override
    public int regist(User user) {
        return userDao.regist(user);
    }

    @Override
    public int modifeRegistInfo(User user) {
        return userDao.modifeRegistInfo(user);
    }

    @Override
    public User checkLogin(User user) {
        return userDao.checkLogin(user);
    }

    @Override
    public User backlogin(User user) {
        return userDao.checkBackLogin(user);
    }

    @Override
    public Page queryAllUserInfo(Page page) {
        int totalCount = userDao.getUserCount();
        int totalPage = totalCount%page.getPageSize()==0?totalCount/page.getPageSize():totalCount/page.getPageSize()+1;
        List<User> list = userDao.getList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        page.setList(list);
        return page;
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void dongjie(Integer id) {
        userDao.dongjie(id);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
