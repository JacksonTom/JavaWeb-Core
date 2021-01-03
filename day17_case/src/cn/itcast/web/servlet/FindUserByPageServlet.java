package cn.itcast.web.servlet;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author JacksonTom
 * @date 2021-01-02
 * @function
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //当前页面
        String s_currentPage = request.getParameter("currentPage");
        int currentPage;
        try {
            currentPage = Integer.parseInt(s_currentPage);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            currentPage = 1;
        }
        if (currentPage <= 0){
            currentPage = 1;
        }
        //每页数量
        String s_rows = request.getParameter("rows");
        int rows;
        try {
            rows = Integer.parseInt(s_rows);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            rows = 10;
        }
        if (rows <= 0 || rows > 100){
            rows = 10;
        }

        //获取查询条件
        Map<String, String[]> condition = request.getParameterMap();

        UserService userService = new UserServiceImpl();
        PageBean<User> userByPage = userService.findUserByPage(currentPage, rows,condition);
        System.out.println(userByPage);
        //存入request，转发
        request.setAttribute("userByPage",userByPage);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
