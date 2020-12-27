<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取对象</title>
</head>
<body>

    <%
        User user = new User();
        user.setName("张三");
        user.setAge(28);
        user.setBirthday(new Date());
        request.setAttribute("user1",user);

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add(user);
        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("name","李四");
        map.put("gender","male");
        map.put("age",22);
        map.put("user1",user);
        request.setAttribute("map",map);
    %>

    <h3>el获取对象</h3>
    ${requestScope.user1}<br>
    ${requestScope.user1.name}<br>
    ${requestScope.user1.age}<br>
    ${requestScope.user1.birthday}<br>
    ${requestScope.user1.birthday.year}<br>
    ${requestScope.user1.birthStr}<br>

    <h3>el获取list</h3>
    ${requestScope.list}<br>
    ${requestScope.list[0]}<br>
    ${requestScope.list[1]}<br>
    ${requestScope.list[2]}<br>
    ${requestScope.list[3]}<br>
    ${requestScope.list[4].name}<br>
    ${requestScope.list[4].age}<br>

    <h3>el获取map</h3>
    ${requestScope.map}<br>
    ${requestScope.map.gender}<br>
    ${requestScope.map["gender"]}<br>
    ${requestScope.map["user1"].name}<br>



</body>
</html>
