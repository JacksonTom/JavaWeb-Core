<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>itcast</title>
</head>
<body>

    <%
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
    %>
                    <h1>欢迎回来，您上次访问时间为:<%=value%></h1>
    <%
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
    %>
            <h1>您好，欢迎您首次访问</h1>
    <%
        }
    %>

    <input>

</body>
</html>
