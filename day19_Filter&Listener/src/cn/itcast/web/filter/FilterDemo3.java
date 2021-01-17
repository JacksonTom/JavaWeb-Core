package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author JacksonTom
 * @date 2021-01-04
 * @function
 */
@WebFilter("/*")
public class FilterDemo3 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo3...开始");
        chain.doFilter(req, resp);
        System.out.println("filterDemo3...结束");
    }

    //服务器启动时执行一次
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    //服务器关闭时执行一次
    public void destroy() {
        System.out.println("destroy...");
    }

}
