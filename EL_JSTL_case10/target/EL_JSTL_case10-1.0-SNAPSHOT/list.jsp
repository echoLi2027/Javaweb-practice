<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    function deleteUser(id) {
      if (confirm("are you sure to delete it?")){
        location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
      }
    }

    window.onload = function () {

      document.getElementById("first_btn").onclick = function () {
      //   1. get all list's cb, by id only got one element
        var cbs = document.getElementsByName("uid");
      //   2. do traverse
        for (var i = 0; i < cbs.length; i++){
          // 3. set those status the same
          // cbs[i].checked = document.getElementById("first_btn").checked;
          cbs[i].checked = this.checked;
        }
      }

      document.getElementById("delSelected").onclick = function () {
        var cbs = document.getElementsByName("uid");
        var flag = false;
        if (confirm("are you sure to delete user?")){
          for (var i = 0; i < cbs.length; i++){
            if (cbs[i].checked){
              flag = true;
              break;
            }
          }

          if (flag){
            document.getElementById("form").submit();
          }
        }

      }
    }
  </script>
</head>
<body>
<div class="container">
  <h3 style="text-align: center">user info list</h3>

  <div style="float: left;">

    <form class="form-inline">
      <div class="form-group">
        <label for="name">name</label>
        <input type="text" name="name" class="form-control" id="name" >
      </div>
      <div class="form-group">
        <label for="address">address</label>
        <input type="text" name="address" class="form-control" id="address" >
      </div>

      <div class="form-group">
        <label for="email">email</label>
        <input type="text" name="email" class="form-control" id="email"  >
      </div>
      <button type="submit" class="btn btn-default">search</button>
    </form>

  </div>

  <div style="float: right;margin: 5px;">

    <a class="btn btn-primary" href="add.jsp">add user</a>
    <a class="btn btn-primary" href="javascript:void(0)" id="delSelected">delete user</a>

  </div>

  <form id="form" action="${pageContext.request.contextPath}/delSelectedUserServlet" method="post">
  <table border="1" class="table table-bordered table-hover">
    <tr class="success">
      <th><input id="first_btn" type="checkbox"></th>
      <th>id</th>
      <th>name</th>
      <th>gender</th>
      <th>age</th>
      <th>address</th>
      <th>QQ</th>
      <th>email</th>
      <th>operation</th>
    </tr>

    <c:forEach items="${pageBean.list}" var="user" varStatus="s">
      <tr>
        <td><input id="id_box" name="uid" value="${user.id}" type="checkbox"></td>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.gender}</td>
        <td>${user.age}</td>
        <td>${user.address}</td>
        <td>${user.qq}</td>
        <td>${user.email}</td>
        <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">update</a>&nbsp;<a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">delete</a></td>
      </tr>

    </c:forEach>


  </table>

  </form>

  <div>
    <nav aria-label="Page navigation">
      <ul class="pagination">
        <c:if test="${pageBean.currentPage==1}">
          <li class="disabled">
        </c:if>

        <c:if test="${pageBean.currentPage!=1}">
          <li>
        </c:if>

          <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pageBean.currentPage - 1}&rows=5" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>

        <c:forEach begin="1" end="${pageBean.totalPage}" var="i">

          <c:if test="${pageBean.currentPage == i}">
            <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
          </c:if>
          <c:if test="${pageBean.currentPage != i}">
            <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
          </c:if>

        </c:forEach>

          <c:if test="${pageBean.currentPage==pageBean.totalPage}">
            <li class="disabled">
          </c:if>
          <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
            <li>
          </c:if>
          <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pageBean.currentPage + 1}&rows=5" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
        <span style="font-size: 25px;margin-left: 5px;">
                    total &nbsp ${pageBean.totalCount} &nbsp records, &nbsp total &nbsp ${pageBean.totalPage} &nbsp pages.
                </span>

      </ul>
    </nav>


  </div>


</div>


</body>
</html>
