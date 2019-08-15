package dao.impl;

import dao.OrderDao;
import entity.Order;
import util.DBUtils;

import javax.sql.rowset.serial.SerialStruct;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDaoImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/12 19:56
 * @Version 1.0
 */
public class OrderDaoImpl extends DBUtils<Order> implements OrderDao {


    @Override
    public void add(Order order) {
        String sql = "insert into t_order values (?,?,?,?,?,?,?,?,?)";
        super.commonOper(sql, order.getId(), order.getO_sendtype(), order.getO_paytype(), order.getO_paycount(),
                new Date(), order.getUserid(), order.getO_shperson(), order.getO_shphone(), order.getO_shaddress());
    }

    @Override
    public int getOrderCount() {
        String sql = "select count(*) from t_order";
        return super.getCount(sql);
    }

    @Override
    public List<Order> getList(int i, int pageSize) {
        String sql = "select * from t_order limit ?,?";
        return super.getList(sql,Order.class,i,pageSize);
    }

}
