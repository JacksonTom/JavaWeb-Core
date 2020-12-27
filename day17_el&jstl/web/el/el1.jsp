<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>el运算</title>
</head>
<body>

    ${3 > 4}
    \${3 > 4}

    <hr>
    <h3>算数运算</h3>
    ${3 * 4}<br>
    ${3 / 4}<br>
    <h3>比较运算符</h3>
    ${3 == 4}
    <h3>逻辑运算符</h3>
    ${3 == 4 && 3 < 4}

    <h4>empty运算符</h4>
    <%
        String str = "";
        request.setAttribute("abc",str);
        List list = new ArrayList();
        request.setAttribute("list",list);
    %>
    ${empty str}<br>
    ${not empty str}<br>
    ${empty requestScope.list}<br>

</body>
</html>
