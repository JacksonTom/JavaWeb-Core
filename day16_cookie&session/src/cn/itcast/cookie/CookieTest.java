package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
    在服务器中的Servlet判断是否有一个名为lastTime的cookie
	1. 有：不是第一次访问
		1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
		2. 写回Cookie：lastTime=2018年6月10日11:50:01
	2. 没有：是第一次访问
		1. 响应数据：您好，欢迎您首次访问
		2. 写回Cookie：lastTime=2018年6月10日11:50:01
*/
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 1.获取所有cookie
        Cookie[] cookies = request.getCookies();
        // 2.遍历cookies
        if(cookies !=null && cookies.length>0){
            for (Cookie c : cookies){
                String name = c.getName();
                if ("lastTime".equals(name)){
                    //不是第一次访问
                    //获取当前时间,重新设置cookie的值
                    System.out.println("存在lastTime");
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String str_date = simpleDateFormat.format(date);

                    //URL解码
                    String value = c.getValue();
                    System.out.println("date解码前： " + value);
                    value= URLDecoder.decode(value,"utf-8");
                    System.out.println("date解码后： " + value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:" + value + "</h1>");

                    //URL编码
                    System.out.println("str_date编码前: "+ str_date);
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("str_date编码后" + str_date);
                    c.setMaxAge(60 * 60 * 24 * 30);//存储一个月
                    c.setValue(str_date);
                    response.addCookie(c);

                    break;
                }
            }
        }else {
            //没有lastTime
            System.out.println("没有lastTime");
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String str_date = simpleDateFormat.format(date);
            str_date = URLEncoder.encode(str_date,"utf-8");
            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60 * 60 * 24 *30);
            response.addCookie(cookie);
            response.getWriter().write("您好，欢迎您首次访问!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
