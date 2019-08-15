package service;

import entity.Order;
import entity.Page;

public interface OrderService {
    void add(Order order);

    Page queryAllOrderList(Page page);
}
