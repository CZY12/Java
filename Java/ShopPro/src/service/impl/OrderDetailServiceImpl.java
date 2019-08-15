package service.impl;

import dao.OrderDetailDao;
import dao.impl.OrderDetailDapImpl;
import entity.OrderDetail;
import service.OrderDetailService;

import java.util.List;

/**
 * @ClassName OrderDetailServiceImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/12 19:49
 * @Version 1.0
 */
public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailDao orderDetailDao = new OrderDetailDapImpl();

    @Override
    public void add(OrderDetail orderDetail) {
        orderDetailDao.add(orderDetail);
    }

    @Override
    public List<OrderDetail> queryAllOrderList(int orderId) {
        return orderDetailDao.queryAllOrderListByOrderId(orderId);
    }
}
