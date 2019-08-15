package web.servlet;

import entity.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import service.GoodInfoService;
import service.OrderDetailService;
import service.OrderService;
import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet","/back/OrderServlet"})
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    public void add(Order order, HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ShopCar shopCar = ShopCar.getShopCar(request.getSession());
        double payCount = shopCar.getTotalPrice();
        order.setO_paycount(payCount);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        StringBuilder stringBuffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        int id = Integer.parseInt(year + stringBuffer.toString());
        order.setId(id);

        User user = (User) request.getSession().getAttribute("LOGIN_USER");
        order.setUserid(user.getId());

        System.out.println(order.getO_shaddress()+","+order.getO_shphone());
        orderService.add(order);

        List<GoodInfo> goodInfoList = shopCar.getList();

        for (GoodInfo good :
                goodInfoList) {
            Class c = GoodsInfoServlet.class;
            Method method = c.getMethod("updateStock", Integer.class, Integer.class);
            method.invoke(c.newInstance(),good.getId(),good.getCount());
            OrderDetail orderDetail = new OrderDetail(id, good.getId(), good.getGoods_name(), good.getGoods_price_off(), good.getGoods_description(), good.getCount(), good.getGoods_pic(), good.getDanPrice());
            orderDetailService.add(orderDetail);
        }

        request.getSession().setAttribute("order", order);
        response.sendRedirect("ShopCarServlet?action=clearShopCar");
    }

    public String queryAllOrderList(Page page, HttpServletRequest request , HttpServletResponse response){
        Page page1 = orderService.queryAllOrderList(page);
        List<Order> orderList = (List<Order>) page1.getList();
        List<List> list = new ArrayList<>();
        for (Order order:
             orderList) {
            int orderId = order.getId();
            List<OrderDetail> orderList1 = orderDetailService.queryAllOrderList(orderId);
            list.add(orderList1);
        }
        page1.setUrl("back/OrderServlet?action=queryAllOrderList");
        request.setAttribute("page",page1);
        request.setAttribute("orderList",page1.getList());
        request.setAttribute("orderInfoList",list);
        return "forward:order/orderlist.jsp";
    }
}
