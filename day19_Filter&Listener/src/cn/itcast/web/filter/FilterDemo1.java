package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author JacksonTom
 * @date 2021-01-03
 * @function
 */
//@WebFilter("/*")//访问所有资源
public class FilterDemo1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo1执行");
        chain.doFilter(req, resp);//放行
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
