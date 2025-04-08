<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

    window.onload = function () {

        document.getElementById("returnBtn").onclick = returnPre;
    }

    function returnPre() {
        location.href = "${pageContext.request.contextPath}/userListServlet";
    }

</script>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">


    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">change user</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">


            <%--    hidden area to submit the id, but be sure it inside the form, only that it can be submitted--%>
            <input type="hidden" name="id" value="${user.id}">

          <div class="form-group">
            <label for="name">name：</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" placeholder="please input name" />
          </div>

          <div class="form-group">
            <label>gender：</label>
              <c:if test="${user.gender=='male'}">
                  <input type="radio" name="gender" value="male"  checked/>male
                  <input type="radio" name="gender" value="female"  />female
              </c:if>
              <c:if test="${user.gender=='female'}">
                  <input type="radio" name="gender" value="male"  />male
                  <input type="radio" name="gender" value="female"  checked/>female
              </c:if>
          </div>

          <div class="form-group">
            <label for="age">age：</label>
            <input type="text" class="form-control" id="age"  value="${user.age}"  name="age" placeholder="please input age" />
          </div>

          <div class="form-group">
            <label for="address">address：</label>
             <select name="address" id="address" class="form-control" >
                 <c:if test="${user.address=='London'}">
                     <option value="London" selected>London</option>
                     <option value="Berlin">Berlin</option>
                     <option value="Seattle">Seattle</option>
                 </c:if>
                 <c:if test="${user.address=='Berlin'}">
                     <option value="London" >London</option>
                     <option value="Berlin" selected>Berlin</option>
                     <option value="Seattle">Seattle</option>
                 </c:if>
                 <c:if test="${user.address=='Seattle'}">
                     <option value="London" >London</option>
                     <option value="Berlin">Berlin</option>
                     <option value="Seattle" selected>Seattle</option>
                 </c:if>
            </select>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq"  value="${user.qq}" name="qq" placeholder="请输入QQ号码"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email"  value="${user.email}" name="email" placeholder="请输入邮箱地址"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="submit" />
                <input class="btn btn-default" type="reset" value="reset" />
                <input class="btn btn-default" type="button" id="returnBtn" value="return" onclick="returnPre()"/>
             </div>
        </form>
        </div>
    </body>
</html>