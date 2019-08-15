package dao;

import entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    void add(OrderDetail orderDetail);

    List<OrderDetail> queryAllOrderListByOrderId(int orderId);
}
