package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author JacksonTom
 * @date 2021-01-04
 * @function
 */
//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request进行增强
        System.out.println("filterDemo2...开始");
        chain.doFilter(req, resp);
        //对response进行增强
        System.out.println("filterDemo2...结束");
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
