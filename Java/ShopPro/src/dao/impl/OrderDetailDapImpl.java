package dao.impl;

import dao.OrderDetailDao;
import entity.OrderDetail;
import util.DBUtils;

import java.util.List;

/**
 * @ClassName OrderDetailDapImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/12 20:03
 * @Version 1.0
 */
public class OrderDetailDapImpl extends DBUtils<OrderDetail> implements OrderDetailDao {

    @Override
    public void add(OrderDetail orderDetail) {
        String sql = "insert into t_order_detail values(null,?,?,?,?,?,?,?,?)";
        super.commonOper(sql,orderDetail.getO_orderid(),orderDetail.getGoodsid(),orderDetail.getGoodsname(),orderDetail.getGoodsprice(),orderDetail.getGoods_description(),orderDetail.getGoodsnum(),orderDetail.getGoodspic(),orderDetail.getGoods_total_price());
    }

    @Override
    public List<OrderDetail> queryAllOrderListByOrderId(int orderId) {
        String sql = "select * from t_order_detail where o_orderid = ?";
        return super.getList(sql,OrderDetail.class,orderId);
    }
}
