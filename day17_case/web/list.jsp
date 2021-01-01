<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>

        window.onload = function () {
            document.getElementById("delSelected").onclick = deleteSelectedConfirm;
            document.getElementById("first").onclick = syncAll;
            let uids = document.getElementsByName("uid");
            for (let i = 0; i < uids.length; i++) {
                uids[i].onclick = sync;
            }
        }

        //所有勾选框与标题行保持一致
        function syncAll() {
            let checked = document.getElementById("first").checked;
            let uids = document.getElementsByName("uid");
            for (let i = 0; i < uids.length; i++) {
                uids[i].checked = checked;
            }
        }

        //标题行勾选框状态
        function sync() {
            let uids = document.getElementsByName("uid");
            let firstStatus = uids[0].checked;
            let sameFlag = false;
            if (1 == uids.length){
                sameFlag = true;
            }
            for (let i = 1; i < uids.length; i++) {
                if (firstStatus != uids[i].checked) {
                    sameFlag = false;
                    break;
                }
                sameFlag = true;
            }
            if (sameFlag) {
                document.getElementById("first").checked = firstStatus;
            }else {
                document.getElementById("first").checked = false;
            }
        }

        //单个删除确认
        function deleteConfirm(id) {
            //用户确认提示
            if (confirm("确定删除用户？")) {
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id=" + id;
            }
        }

        //删除选中确认
        function deleteSelectedConfirm() {
            let uids = document.getElementsByName("uid");
            let flag = false;
            for (let i = 0; i < uids.length; i++) {
                if (uids[i].checked) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                if (confirm("确认删除所有选中用户吗？")) {
                    document.getElementById("form").submit();
                }
            } else {
                alert("未选中任何用户。")
            }
        }
    </script>

</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float:right;margin: 5px">
        <td colspan="8" align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        </td>
        <td colspan="8" align="center"><a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
        </td>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/deleteSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="first"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="uid" value="${user.id}"></th>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>
                        <a class="btn btn-default btn-sm" href="javascript:deleteConfirm(${user.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px;margin-left: 5px">
                共16条记录，共4页
            </span>
        </ul>
    </nav>

</div>
</body>
</html>
