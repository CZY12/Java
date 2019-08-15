package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Order;
import entity.Page;
import service.OrderService;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/12 19:29
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    public Page queryAllOrderList(Page page) {
        int totalCount = orderDao.getOrderCount();
        int totalPage = totalCount%page.getPageSize()==0?totalCount/page.getPageSize():totalCount/page.getPageSize()+1;
        List<Order> list = orderDao.getList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        page.setList(list);
        return page;
    }
}
