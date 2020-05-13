package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 字符输出流输出数据
        //response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");//同时设置流、浏览器的编码
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1>response在一次响应之后自动销毁，故不需要刷新printWriter即可写出。</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
