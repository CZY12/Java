package web.filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "BackLoginFilter", urlPatterns = "/back/*")
public class BackLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("BACK_LOGIN");
        if (user!=null){
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect("../backLogin.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
