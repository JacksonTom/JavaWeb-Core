<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" errorPage="500.jsp" language="java" buffer="8kb"%>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

    <%--
        List list = new ArrayList();
        int i = 3/0;
        <c:if test="">
    --%>


    <%--
    内置对象
    变量名                 实际对象                作用范围
    1.pageContext         PageContext           当前页面（获取其他八个内置对象）
    2.request             HttpServletRequest    以此请求访问的多个资源
    3.session             HttpSession           一次会话的多个请求
    4.application         ServletContext        整个应用
    5.response            HttpServletResponse   相应对象
    6.page                Object                当前页面
    7.out                 JspWriter             输出对象
    8.config              ServletConfig         配置对象
    9.exception           Throwable             异常
    --%>
    <h1>演示</h1>
    <%
        pageContext.setAttribute("msg","你好pageContext");
    %>

    <%=
        pageContext.getAttribute("msg")
    %>


</body>
</html>