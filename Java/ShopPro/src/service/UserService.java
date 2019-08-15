package service;

import entity.Page;
import entity.User;

import java.util.List;

public interface UserService {
    User checkUserNameExits(String username);

    int regist(User user);

    int modifeRegistInfo(User user);

    User checkLogin(User user);

    User backlogin(User user);

    Page queryAllUserInfo(Page page);

    int add(User user);

    User findById(Integer id);

    void update(User user);

    void dongjie(Integer id);

    void delete(Integer id);
}
