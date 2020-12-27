<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>

<%--
begin:开始值
end:结束值
var:临时变量
step:步长
--%>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>
<c:forEach begin="1" end="10" var="i" varStatus="s">
    ${i} ${s.index} ${s.current} ${s.count}<br>
</c:forEach>

<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
%>
<c:forEach items="${requestScope.list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str} <br>
</c:forEach>

</body>
</html>
