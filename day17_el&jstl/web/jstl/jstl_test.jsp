<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List list = new ArrayList();
    list.add(new User("张三",24,new Date()));
    list.add(new User("李四",25,new Date()));
    list.add(new User("王五",26,new Date()));
    list.add(new User("刘六",26,new Date()));
    request.setAttribute("userList",list);
%>

<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${userList}" var="u" varStatus="s">
        <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="#ff4500">
                <th>${s.count}</th>
                <th>${u.name}</th>
                <th>${u.age}</th>
                <th>${u.birthStr}</th>
            </tr>
        </c:if>
        <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="#6495ed">
                <th>${s.count}</th>
                <th>${u.name}</th>
                <th>${u.age}</th>
                <th>${u.birthStr}</th>
            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>
