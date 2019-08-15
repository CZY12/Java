package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {
    public CharacterEncodingFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //解决post请求方式的乱码
        if (req.getServletPath().endsWith(".css") || req.getServletPath().endsWith(".js")) {
            chain.doFilter(req, resp);
        } else {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            MyCharacterEncodingFilterWrapper wrapper = new MyCharacterEncodingFilterWrapper(req);
            chain.doFilter(wrapper, resp);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}

class MyCharacterEncodingFilterWrapper extends HttpServletRequestWrapper {

    public MyCharacterEncodingFilterWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        //得到表单提交的数据
        String value = super.getParameter(name);
        //得到请求方式
        String method = super.getMethod();
        if ("GET".equals(method)) {
            try {
                value = new String(value.getBytes("iso-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return value;
    }

}
