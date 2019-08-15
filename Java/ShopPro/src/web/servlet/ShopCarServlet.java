package web.servlet;

import entity.GoodInfo;
import entity.ShopCar;
import service.GoodInfoService;
import service.impl.GoodInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShopCarServlet", urlPatterns = "/ShopCarServlet")
public class ShopCarServlet extends BaseServlet {

    private GoodInfoService goodInfoService = new GoodInfoServiceImpl();

    public String add(Integer id,Integer count,HttpServletRequest request){
        ShopCar shopCar = ShopCar.getShopCar(request.getSession());
        GoodInfo goodInfo = goodInfoService.queryById(id);
        goodInfo.setCount(count);
        shopCar.add(goodInfo);
        return "redirect:shopcar.jsp";
    }

    public String update(Integer id,Integer count , HttpServletRequest request){
        ShopCar shopCar = (ShopCar) request.getSession().getAttribute("SHOP_CAR");
        shopCar.update(id,count);
        return "redirect:shopcar.jsp";
    }

    public String delete(Integer id,HttpServletRequest request){
        ShopCar shopCar = (ShopCar) request.getSession().getAttribute("SHOP_CAR");
        shopCar.delete(id);
        return "redirect:shopcar.jsp";
    }
    public String clearShopCar(HttpServletRequest request){
        ShopCar shopCar = (ShopCar) request.getSession().getAttribute("SHOP_CAR");
        shopCar.getList().clear();
        return "redirect:success.jsp";
    }

    public void updatePay(Integer id, Integer count , HttpServletRequest request, HttpServletResponse response) throws IOException {
        ShopCar shopCar = (ShopCar) request.getSession().getAttribute("SHOP_CAR");
        shopCar.update(id,count);
        response.sendRedirect("PayServlet?action=checkLogin");
    }
}
