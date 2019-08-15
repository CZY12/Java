package web.servlet;

import com.sun.deploy.net.HttpResponse;
import entity.Page;
import entity.User;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet","/back/UserServlet"})
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void checkUserNameExits(String username, HttpServletResponse response) throws IOException {
        //查询
        User user = userService.checkUserNameExits(username);
        //判断用户名是否已经使用，然后返回标识
        if (user == null) {
            response.getWriter().write("0");
        } else {
            response.getWriter().write("1");
        }
    }

    public void regist(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int result = userService.regist(user);
        if (result > 0) {
            request.getSession().setAttribute("REGIST_USER",user);
            response.getWriter().write("<script>alert('注册成功，请完善信息');location.href='information.jsp';</script>");
        }else
            response.getWriter().write("<script>alert('注册失败，请重新注册');location.href='register.jsp';</script>");

    }

    public void modifeRegistInfo(User user,HttpServletRequest request , HttpServletResponse response) throws IOException {
        User registerUser = (User) request.getSession().getAttribute("REGIST_USER");
        user.setUser_name(registerUser.getUser_name());
        user.setPwd(registerUser.getPwd());
        int result = userService.modifeRegistInfo(user);
        if (result > 0) {
            request.getSession().setAttribute("REGIST_USER",user);
            response.getWriter().write("<script>alert('信息完善成功，即将跳转到登录页面');location.href='login.jsp';</script>");
        }else
            response.getWriter().write("<script>alert('信息完善失败');location.href='register.jsp';</script>");
    }

    public void login(User user,String remember_me,HttpServletRequest request,HttpServletResponse response) throws IOException{
        User loginUser = userService.checkLogin(user);
        if(loginUser!=null){
            //登录成功
            if ("on".equals(remember_me)){
                Cookie c1 = new Cookie("user_name", URLEncoder.encode(loginUser.getUser_name(),"utf-8"));
                Cookie c2 = new Cookie("pwd",String.valueOf(loginUser.getPwd()));
                c1.setMaxAge(60);
                c2.setMaxAge(60);
                response.addCookie(c1);
                response.addCookie(c2);
            }
            response.getWriter().write("<script>location.href='home.jsp'</script>");
            request.getSession().setAttribute("LOGIN_USER", loginUser);
        }else{
            response.getWriter().write("<script>alert('登录失败');location.href='login.jsp'</script>");
        }
    }

    public void zhuxiao(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("LOGIN_USER");
        response.sendRedirect("home.jsp");
    }

    public void backlogin(User user,HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user1 = userService.backlogin(user);
        if (user1==null){
            response.getWriter().write("<script>alert('登录失败，其检查您的账号密码，并确认您是管理员身份');location.href='backLogin.jsp';</script>");
        }else {
            request.getSession().setAttribute("BACK_LOGIN",user1);
            response.sendRedirect("back/main.jsp");
        }
    }

    public String queryAllUserInfo(Page page ,HttpServletRequest request, HttpServletResponse response){
        Page page1 = userService.queryAllUserInfo(page);
        page1.setUrl("back/UserServlet?action=queryAllUserInfo");
        request.setAttribute("page",page1);
        return "forward:user/userinfo.jsp";
    }

    public void add(User user,HttpServletResponse response) throws IOException {
        int result = userService.add(user);
        if (result>0){
            response.sendRedirect("UserServlet?action=queryAllUserInfo");
        }else
            response.getWriter().write("<script>alert('添加失败！');location.href='UserServlet?action=queryAllUserInfo';</script>");
    }

    public String toUpdate(Integer id,HttpServletRequest request){
        User user = userService.findById(id);
        request.setAttribute("user",user);
        return "forward:user/updateuser.jsp";
    }

    public String update(User user){
        userService.update(user);
        return "forward:UserServlet?action=queryAllUserInfo";
    }

    public String dongjie(Integer id){
        userService.dongjie(id);
        return "redirect:UserServlet?action=queryAllUserInfo";
    }

    public String delete(Integer id){
        userService.delete(id);
        return "redirect:UserServlet?action=queryAllUserInfo";
    }
}
