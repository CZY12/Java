package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    User checkUserExits(String username);

    int regist(User user);

    int modifeRegistInfo(User user);

    User checkLogin(User user);

    User checkBackLogin(User user);

    List<User> queryAllUserInfo();

    int getUserCount();

    List<User> getList(int currentPage, int pageSize);

    int add(User user);

    User findById(Integer id);

    void update(User user);

    void dongjie(Integer id);

    void delete(Integer id);
}
