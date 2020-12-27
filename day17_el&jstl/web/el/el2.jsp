<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>

</head>
<body>

    <%
        request.setAttribute("name","张三");
        request.setAttribute("age","23");
        session.setAttribute("name","李四");
    %>

    <h3>el获取值</h3><br>
    <%--
        pageSocpe
        requestScope
        sessionScope
        applicationScope
    --%>
    ${requestScope.name}<br>
    ${requestScope.age}<br>
    ${requestScope.haha}<br>
    ${name}<br>

</body>
</html>
