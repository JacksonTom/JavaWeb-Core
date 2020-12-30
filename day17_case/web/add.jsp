<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <style>
        .error {
            color: red;
        }
    </style>

    <script>
        window.onload = function () {
            //给所有输入框绑定离焦事件
            document.getElementById("name").onblur = checkName;
            document.getElementById("age").onblur = checkAge;
            document.getElementById("qq").onblur = checkQQ;
            document.getElementById("email").onblur = checkEmail;
            //form总校验
            document.getElementById("form").onsubmit = function () {
                return checkName() && checkAge() && checkAge() && checkEmail();
            }
        }

        //1.校验name
        function checkName() {
            //1.获取用户名的值
            let name = document.getElementById("name").value;
            //2.定义正则表达式
            let reg_name = /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/;
            //3.判断值是否符合正则的规则
            let flag = reg_name.test(name);
            //4.提示信息
            let s_name = document.getElementById("s_name");
            if (!flag) {
                //提示红色用户名有误
                s_name.innerHTML = "用户名格式有误,支持5-24位字符：中文、英文、数字、“_”";
            }else{
                s_name.innerHTML = null;
            }
            return flag;
        }

        //2.校验age
        function checkAge() {
            //1.获取值
            let age = document.getElementById("age").value;
            //2.定义正则表达式（1-120岁）
            let reg_age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
            //3.判断值是否符合正则的规则
            let flag = reg_age.test(age);
            //4.提示信息
            let s_age = document.getElementById("s_age");
            if (!flag) {
                //提示红色
                s_age.innerHTML = "年龄格式有误：必须1-120的整数";
            }else{
                s_age.innerHTML = null;
            }
            return flag;
        }

        //3.校验qq
        function checkQQ() {
            //1.获取值
            let qq = document.getElementById("qq").value;
            //2.定义正则表达式（QQ号码）
            let reg_qq = /^[1-9][0-9]{4,14}$/;
            //3.判断值是否符合正则的规则
            let flag = reg_qq.test(qq);
            //4.提示信息
            let s_qq = document.getElementById("s_qq");
            if (!flag) {
                //提示红色年龄有误
                s_qq.innerHTML = "QQ格式有误";
            }else{
                s_qq.innerHTML = null;
            }
            return flag;
        }

        //4.校验email
        function checkEmail() {
            //1.获取值
            let email = document.getElementById("email").value;
            //2.定义正则表达式（QQ号码）
            let reg_email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
            //3.判断值是否符合正则的规则
            let flag = reg_email.test(email);
            //4.提示信息
            let s_email = document.getElementById("s_email");
            if (!flag) {
                //提示红色年龄有误
                s_email.innerHTML = "email格式有误";
            }else{
                s_email.innerHTML = null;
            }
            return flag;
        }
    </script>

</head>
<body>
<div class="container">
    <h3 style="text-align: center">添加联系人页面</h3>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            <span id="s_name" class="error"></span>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            <span id="s_age" class="error"></span>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" id="qq" placeholder="请输入QQ号码"/>
            <span id="s_qq" class="error"></span>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" id="email" placeholder="请输入邮箱地址"/>
            <span id="s_email" class="error"></span>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>