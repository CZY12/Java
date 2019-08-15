package dao.impl;

import dao.AddressDao;
import entity.Address;
import util.DBUtils;

import java.util.List;

/**
 * @ClassName AddressDaoImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/12 16:09
 * @Version 1.0
 */
public class AddressDaoImpl extends DBUtils<Address> implements AddressDao {

    @Override
    public List<Address> queryByUserId(int id) {
        String sql = "select * from t_address where userid = ?";
        return super.getList(sql,Address.class,id);
    }
}
