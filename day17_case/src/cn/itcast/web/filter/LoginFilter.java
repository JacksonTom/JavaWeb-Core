package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author JacksonTom
 * @date 2021-01-14
 * @function 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        //排除掉css、js、验证码等资源
        if(uri.contains("/login.jsp")
        || uri.contains("/loginServlet")
        || uri.contains("/css/")
        || uri.contains("/js/")
        || uri.contains("/fonts/")
        || uri.contains("/checkCodeServlet")){
            //用户想登录，放行
            chain.doFilter(req, resp);
        }else{
            //验证是否登录
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
