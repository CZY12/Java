package dao.impl;

import dao.UserDao;
import entity.User;
import util.DBUtils;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/10 16:44
 * @Version 1.0
 */
public class UserDaoImpl extends DBUtils<User> implements UserDao {
    @Override
    public User checkUserExits(String username) {
        String sql = "select * from t_user where user_name = ?";
        return super.getSingleInsatnce(sql,User.class,username);
    }

    @Override
    public int regist(User user) {
        String sql = "insert into t_user (user_name,pwd) values (?,?)";
        return super.commonOper(sql,user.getUser_name(),user.getPwd());
    }

    @Override
    public int modifeRegistInfo(User user) {
        String sql = "update t_user set nick_name=?,sex=?,birthday=?,phone=?,codes=?,email=?,address=?,isadmin=?,regist_date=?,lockstate=? where user_name=?";
        return super.commonOper(sql,user.getNick_name(), user.getSex(), user.getBirthday(), user.getPhone(),
                user.getCodes(), user.getEmail(), user.getAddress(), "否", new Date(), 0, user.getUser_name());
    }

    @Override
    public User checkLogin(User user) {
        String sql = "select * from t_user where user_name = ? and pwd = ?";
        return super.getSingleInsatnce(sql,User.class,user.getUser_name(),user.getPwd());
    }

    @Override
    public User checkBackLogin(User user) {
        String sql = "select * from t_user where user_name = ? and pwd = ? and isadmin = '是'";
        return super.getSingleInsatnce(sql,User.class,user.getUser_name(),user.getPwd());
    }

    @Override
    public List<User> queryAllUserInfo() {
        String sql = "select * from t_user";
        return super.getList(sql,User.class);
    }

    @Override
    public int getUserCount() {
        String sql = "select count(*) from t_user";
        return super.getCount(sql);
    }

    @Override
    public List<User> getList(int currentPage, int pageSize) {
        String sql = "select * from t_user limit ?,?";
        return super.getList(sql,User.class,currentPage,pageSize);
    }

    @Override
    public int add(User user) {
        String sql = "insert into t_user values (null,?,?,?,?,?,?,?,?,?,?,?,?)";
        return super.commonOper(sql,user.getUser_name(),user.getNick_name(),user.getPwd(),user.getSex(),user.getBirthday(),user.getPhone(),user.getEmail(),new Date(),user.getAddress(),user.getCodes(),user.getIsadmin(),0);
    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from t_user where id = ?";
        return super.getSingleInsatnce(sql,User.class,id);
    }

    @Override
    public void update(User user) {
        String sql = "update t_user set user_name = ?,nick_name = ? , pwd = ? , sex = ? ,birthday = ?, phone = ? ,email = ? address = ? codes =? ,isadmin = ? ,id=?";
        super.commonOper(sql,user.getUser_name(),user.getNick_name(),user.getPwd(),user.getSex(),user.getBirthday(),user.getPhone(),user.getEmail(),user.getAddress(),user.getIsadmin(),user.getId());
    }

    @Override
    public void dongjie(Integer id) {
        String sql = "update t_user set lockstate = 1 where id = ?";
        super.commonOper(sql,id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from t_user where id = ?";
        super.commonOper(sql,id);
    }
}
