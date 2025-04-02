<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>


    <script>

        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "./checkCodeServlet?time=" + new Date().getTime();
            }
        }

    </script>
    <style>
        div{
            color: red;
        }

    </style>
</head>
<body>

    <form action="./loginServlet" method="post">
        <table>
            <tr>
                <td>username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>checkCode</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="./checkCodeServlet"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="login"></td>
            </tr>
        </table>


        <div>${requestScope.cc_error}</div>

        <div>${requestScope.login_error}</div>


        <%--<div>
            <%= request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>
        </div>

        <div>
            <%= request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
        </div>
--%>

    </form>


</body>
</html>
