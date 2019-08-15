package web.servlet;

import entity.GoodType;
import entity.Page;
import net.sf.json.JSONArray;
import service.GoodTypeService;
import service.impl.GoodTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsTypeServlet", urlPatterns = {"/GoodsTypeServlet","/back/GoodsTypeServlet"})
public class GoodsTypeServlet extends BaseServlet {

    private GoodTypeService goodTypeService = new GoodTypeServiceImpl();


    //查找所有商品类型
    public String queryType(HttpServletRequest request){
        List<GoodType> list = goodTypeService.queryAll();
        request.setAttribute("gList",list);
        return "forward:goods/goodsadd.jsp";
    }

    //根据大类的id查询小的商品类型
    public void querySmallTypeByBigType(Integer id ,HttpServletResponse response) throws IOException {
        List<GoodType> list = goodTypeService.queryByBigType(id);
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.getWriter().write(jsonArray.toString());
    }

    //分页查询所有商品类型
    public String queryAllType(Page page,HttpServletRequest request){
        Page page1 = goodTypeService.queryAllType(page);
        page1.setUrl("back/GoodsTypeServlet?action=queryAllType");
//        List<GoodType> list = goodTypeService.quertSamllType();
        request.setAttribute("page",page1);
//        request.setAttribute("smallType",list);
        return "forward:goodstype/goodstype.jsp";
    }

    //查询所有商品类型返回到goodsadd.jsp页面
    public String queryFather(HttpServletRequest request){
        List<GoodType> list = goodTypeService.queryAll();
        request.setAttribute("gList",list);
        return "forward:goodstype/goodsadd.jsp";
    }

    public void add(GoodType goodType,HttpServletResponse response) throws IOException {
        int result = goodTypeService.add(goodType);
        if (result>0){
            response.sendRedirect("GoodsTypeServlet?action=queryAllType");
        }else
            response.getWriter().write("<script>alert('添加失败！');location.href='GoodsTypeServlet?action=queryAllType';</script>");
    }

    public String toUpdate(Integer id,HttpServletRequest request){
        List<GoodType> list = goodTypeService.queryAll();
        request.setAttribute("gList",list);
        GoodType goodType = goodTypeService.queryallById(id);
        request.setAttribute("type",goodType);
        return "forward:goodstype/goodstypeupdate.jsp";
    }

    public void update(GoodType goodType,HttpServletResponse response) throws IOException {
        int result = goodTypeService.update(goodType);
        if (result>0){
            response.sendRedirect("GoodsTypeServlet?action=queryAllType");
        }else
            response.getWriter().write("<script>alert('修改失败！');location.href='GoodsTypeServlet?action=queryAllType';</script>");
    }
    public void delete(Integer id,HttpServletResponse response) throws IOException {
        int result = goodTypeService.delete(id);
        if (result>0){
            response.sendRedirect("GoodsTypeServlet?action=queryAllType");
        }else
            response.getWriter().write("<script>alert('删除失败！');location.href='GoodsTypeServlet?action=queryAllType';</script>");
    }
}
