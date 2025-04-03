<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: zhouziyan
  Date: 02.04.25
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl case</title>
</head>
<body>
<%
  List list = new ArrayList();
  list.add(new User("Sheldon","123", new Date()));
  list.add(new User("Leonard","234", new Date()));
  list.add(new User("Amy","345", new Date()));

  request.setAttribute("list",list);


%>

<table border="1" width="500" align="center">

  <tr>
    <th>id</th>
    <th>name</th>
    <th>password</th>
    <th>birthday</th>

  </tr>

  <c:forEach items="${list}" var="user" varStatus="s">
    <c:if test="${s.count % 2 == 0}">
      <tr bgcolor="#7fffd4">
        <td>${s.count}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.birthday}</td>ui8
      </tr>
    </c:if>
    <c:if test="${s.count % 2 != 0}">
      <tr bgcolor="aqua">
        <td>${s.count}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.birthday}</td>
      </tr>
    </c:if>
  </c:forEach>
</table>

</body>
</html>
