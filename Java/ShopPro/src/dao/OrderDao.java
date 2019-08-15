package dao;

import entity.Order;

import java.util.List;

public interface OrderDao {
    void add(Order order);

    int getOrderCount();

    List<Order> getList(int i, int pageSize);
}
