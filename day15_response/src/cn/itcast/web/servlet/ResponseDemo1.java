package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 重定向
* 跳转到 /responseDemo2
 * */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1...");

        // 设置状态码为302
        //response.setStatus(302);
        // 设置响应头
        //response.setHeader("location","/day15_response/responseDemo2");

        // 简单重定向-动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
