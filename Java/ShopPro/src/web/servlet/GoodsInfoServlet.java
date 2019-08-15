package web.servlet;

import entity.GoodInfo;
import entity.GoodType;
import entity.Page;
import service.GoodInfoService;
import service.impl.GoodInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "GoodsInfoServlet", urlPatterns = {"/GoodsInfoServlet", "/back/GoodsInfoServlet"})
public class GoodsInfoServlet extends BaseServlet {

    private GoodInfoService goodInfoService = new GoodInfoServiceImpl();

    public String queryById(Integer id, HttpServletRequest request) {
        GoodInfo goodInfo = goodInfoService.queryById(id);
        request.setAttribute("good", goodInfo);
        return "forward:introduction.jsp";
    }

    public String queryAllGoodsInfo(Page page, HttpServletRequest request) {

        Page page1 = goodInfoService.queryAllGoodsInfo(page);
        page1.setUrl("back/GoodsInfoServlet?action=queryAllGoodsInfo");
        request.setAttribute("page", page1);
        return "forward:goods/goodsList.jsp";
    }

    public void add(GoodInfo goodInfo, HttpServletResponse response) throws IOException {
        int result = goodInfoService.add(goodInfo);
        if (result > 0) {
            response.getWriter().write("<script>location.href='GoodsInfoServlet?action=queryAllGoodsInfo';</script>");
        } else
            response.getWriter().write("<script>alert('添加失败！');location.href='GoodsTypeServlet?action=queryType';</script>");
    }

    public String toUpdate(Integer id, HttpServletRequest request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class g = GoodsTypeServlet.class;
        Method method = g.getMethod("queryType",HttpServletRequest.class);
        String result  = (String) method.invoke(g.newInstance(),request);
        System.out.println(result);
        List<GoodType> list = (List<GoodType>) request.getAttribute("gList");
//        for (GoodType goodType:
//             list) {
//            System.out.println(goodType.getId());
//        }
        request.setAttribute("goodTypeList",list);
        GoodInfo goodInfo = goodInfoService.queryById(id);
        request.setAttribute("good",goodInfo);
        return "forward:goods/goodupdate.jsp";
    }

    public void delete(Integer id,HttpServletResponse response) throws IOException {
        int result = goodInfoService.delete(id);
        if (result>0){
            response.sendRedirect("GoodsInfoServlet?action=queryAllGoodsInfo");
        }else
            response.getWriter().write("<script>alert('删除失败！');location.href='GoodsInfoServlet?action=queryAllGoodsInfo';</script>");
    }

    public void update(GoodInfo goodInfo,HttpServletResponse response) throws IOException {
        int result = goodInfoService.update(goodInfo);
        if (result>0){
            response.sendRedirect("GoodsInfoServlet?action=queryAllGoodsInfo");
        }else
            response.getWriter().write("<script>alert('修改失败！');location.href='GoodsInfoServlet?action=queryAllGoodsInfo';</script>");
    }

    public void updateStock(Integer id, Integer stock){
        goodInfoService.updateStock(id,stock);
    }
}
