package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author JacksonTom
 * @date 2020-12-28
 * @function
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.验证码
        String verifycode = request.getParameter("verifycode");
        String checkcode_server = (String)request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");//获取服务器生成的验证码立马销毁
        if (!checkcode_server.equalsIgnoreCase(verifycode)){
            //提示与跳转
            request.setAttribute("login_msg","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //3.封装对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用Service查询
        UserServiceImpl userService = new UserServiceImpl();
        User user_login = userService.login(user);
        //5.判断是否登录成功
        if (null != user_login){
            //用户存入session后跳转
            request.setAttribute("user",user_login);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else {
            //提示与跳转
            request.setAttribute("login_msg","用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
