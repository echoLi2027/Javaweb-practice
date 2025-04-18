<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- HTML5文档-->
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
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <style>
        .error{
            color: red;
        }
    </style>

    <script>

        window.onload = function () {

            document.getElementById("form").onsubmit = function () {
                return checkName()&&checkAge()&&checkQQ()&&checkEmail();
            }

            document.getElementById("name").onblur = checkName;
            document.getElementById("age").onblur = checkAge;
            document.getElementById("qq").onblur = checkQQ;
            document.getElementById("email").onblur = checkEmail;

            document.getElementById("returnBtn").onclick = returnPre;
        }


        function checkName() {
            var name = document.getElementById("name").value;
            var name_reg = /^\w{6,32}$/;
            var flag = name_reg.test(name);
            if (flag){
                document.getElementById("s_name").innerHTML = "<img width='35' height='25' src='img/gou.png'/>"
            }else{
                document.getElementById("s_name").innerHTML = "the format of name is wrong."
            }

            return flag;
        }

        function checkAge() {
            var age = document.getElementById("age").value;

            var s_age = document.getElementById("s_age");

            //     define regExp
            var regexp = /^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$/;

            var flag = regexp.test(age);

            if (flag){
                s_age.innerHTML = "<img width='35' height='25' src = 'img/gou.png'/>";
            }else{
                s_age.innerHTML = "age format incorrect."
            }

            return flag;
        }


        function checkQQ() {
            var qq = document.getElementById("qq").value;
            var qq_reg = /^\w{4,15}$/;
            var flag = qq_reg.test(qq);
            if (flag){
                document.getElementById("s_qq").innerHTML = "<img width='35' height='25' src='img/gou.png'/>"
            }else{
                document.getElementById("s_qq").innerHTML = "the format of qq is wrong."
            }

            return flag;
        }

        function checkEmail() {
            var email = document.getElementById("email").value;
            var email_reg = /^\w{1,}@\w{1,}\.\w{1,}$/;
            var flag = email_reg.test(email);
            if (flag){
                document.getElementById("s_email").innerHTML = "<img width='35' height='25' src='img/gou.png'/>"
            }else{
                document.getElementById("s_email").innerHTML = "the format of email is wrong."
            }

            return flag;
        }

        function returnPre() {
            location.href = "${pageContext.request.contextPath}/findUserByPageServlet";
        }


    </script>
</head>
<body>
<div class="container">
    <center><h3>add users</h3></center>
    <form id="form" name="form" action="./addUserServlet" method="post">
        <div class="form-group">
            <label for="name">name：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="please input name">
            <span id="s_name" class="error"></span>
        </div>

        <div class="form-group">
            <label>gender：</label>
            <input type="radio" name="gender" value="male" checked="checked"/>male
            <input type="radio" name="gender" value="female"/>female
        </div>

        <div class="form-group">
            <label for="age">age：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="please input your age">
            <span id="s_age" class="error"></span>
        </div>

        <div class="form-group">
            <label for="address">address：</label>
            <select name="address" class="form-control" id="address">
                <option value="London">London</option>
                <option value="Berlin">Berlin</option>
                <option value="Seattle">Seattle</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" placeholder="please input qq"/>
            <span id="s_qq" class="error"></span>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" placeholder="please input email"/>
            <span id="s_email" class="error"></span>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="submit" />
            <input class="btn btn-default" type="reset" value="reset" />
            <input class="btn btn-default" id="returnBtn" type="button" onclick="returnPre()" value="return" />
        </div>
    </form>
</div>
</body>
</html>