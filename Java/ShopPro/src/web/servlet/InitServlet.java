package web.servlet;

import entity.GoodInfo;
import entity.GoodType;
import service.GoodInfoService;
import service.GoodTypeService;
import service.impl.GoodInfoServiceImpl;
import service.impl.GoodTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@WebServlet(name = "InitServlet", urlPatterns = "/InitServlet")
public class InitServlet extends BaseServlet {

     private GoodTypeService goodTypeService = new GoodTypeServiceImpl();
     private GoodInfoService goodInfoService = new GoodInfoServiceImpl();
     public String queryAll(HttpServletRequest request){
          List<GoodType> goodTypeList = goodTypeService.queryAll();
          List<GoodInfo> goodInfoList = goodInfoService.queryAll();
          request.setAttribute("goodTypeList",goodTypeList);
          request.setAttribute("goodInfoList",goodInfoList);
          return "forward:index.jsp";
     }
}
