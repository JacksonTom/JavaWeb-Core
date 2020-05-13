package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        // 获取文件路径
        String realPath_b = servletContext.getRealPath("/b.txt");
        String realPath_c = servletContext.getRealPath("/WEB-INF/c.txt");
        String realPath_a = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println("realPath_b: " + realPath_b);
        System.out.println("realPath_c: " + realPath_c);
        System.out.println("realPath_a: " + realPath_a);
        // File file = new File(realPath);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
