<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%----%>
<c:if test="true">
    <h1>true</h1><br>
</c:if>
<c:if test="false">
    <h1>false</h1><br>
</c:if>

<%
    List list = new ArrayList();
    list.add("abc");
    request.setAttribute("list",list);
    request.setAttribute("number",4);
%>
<c:if test="${not empty list}">
    <h1>遍历集合</h1><br>
</c:if>
<c:if test="${requestScope.number%2 == 0}">
    <h1>${requestScope.number}为偶数</h1><br>
</c:if>

</body>
</html>
