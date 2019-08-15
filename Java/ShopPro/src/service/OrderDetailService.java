package service;

import entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    void add(OrderDetail orderDetail);

    List<OrderDetail> queryAllOrderList(int orderId);
}
