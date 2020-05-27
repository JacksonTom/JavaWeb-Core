package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码格式
        request.setCharacterEncoding("utf-8");
        // 2.获取参数Map
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        System.out.println("输入的验证码为： " + checkCode);

        // 3.先判断验证码
        String checkCode_session = (String) request.getSession().getAttribute("checkCode");
        request.getSession().removeAttribute("checkCode");
        if (checkCode_session.equalsIgnoreCase(checkCode)){
            // 校验用户名密码
            if ("zhangsan".equals(username) && "123".equals(password)){
                // 登录成功
                System.out.println("登录成功");
                request.getSession().setAttribute("username",username);
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            }else {
                // 登录失败
                System.out.println("登录失败");
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else {
            // 验证码错误
            System.out.println("验证码错误");
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
