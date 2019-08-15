package web.servlet;

import entity.Address;
import entity.User;
import service.UserService;
import service.impl.AddressServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PayServlet", urlPatterns = "/PayServlet")
public class PayServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();
    private AddressServiceImpl addressService = new AddressServiceImpl();

    public void checkLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("LOGIN_USER");
        if (user==null){
            response.getWriter().write("<script>alert('您还未登录，请登录后进行结算');location.href='login.jsp'</script>");
        }else {
            List<Address> addressList = addressService.queryByUserId(user.getId());
            request.getSession().setAttribute("addressList",addressList);
            response.getWriter().write("<script>location.href='pay.jsp';</script>");
        }
    }
}
