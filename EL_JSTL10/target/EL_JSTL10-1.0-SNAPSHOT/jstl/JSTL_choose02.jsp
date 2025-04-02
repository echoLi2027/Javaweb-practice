<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <title>jstl if</title>
</head>
<body>
<%--it's like switch and case--%>
<%
  request.setAttribute("number", 5);
%>
<c:choose>
  <c:when test="${number == 1}">Monday</c:when>
  <c:when test="${number == 2}">Tuesday</c:when>
  <c:when test="${number == 3}">Wednesday</c:when>
  <c:when test="${number == 4}">Thursday</c:when>
  <c:when test="${number == 5}">Friday</c:when>
  <c:when test="${number == 6}">Saturday</c:when>
  <c:when test="${number == 7}">Sunday</c:when>

  <c:otherwise>input is wrong.</c:otherwise>

</c:choose>

</body>
</html>
