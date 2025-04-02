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
<%--if tag
    1. attr:
      test(required):
        1. if expression is true, then show the content in if tag, otherwise show nothing
        2. usually this will combine with el expression
--%>

<c:if test="true">
  <h1>hello there...</h1>
</c:if>

<%--  check wether this list is empty--%>
<%

  List list = new ArrayList();
  list.add("test");

  request.setAttribute("list", list);

  request.setAttribute("number",4);

%>

<c:if test="${not empty requestScope.list}">
  traverse the list...
</c:if>

<c:if test="${(requestScope.number mod 2) == 0}">
  ${requestScope.number} is odd.
</c:if>

<c:if test="${(requestScope.number mod 2) != 0}">
  ${requestScope.number} is even.
</c:if>

</body>
</html>
