<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <%
        System.out.println("hello JSP");
        int i = 5;

        String contextPath = request.getContextPath();
        out.print(contextPath);
    %>

    <%!
        int i = 3;
    %>

    <%=
        i
    %>
    <%--
    1. <%  代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
    2. <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置。
    3. <%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。
    --%>
</body>
</html>
