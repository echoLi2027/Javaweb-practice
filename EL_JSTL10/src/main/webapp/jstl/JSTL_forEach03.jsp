<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %><%--
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
    <title>jstl forEach</title>
</head>
<body>
<%--
  for each attr:
    begin: initial index
    end: end index
    var: temporary variable like i in for loop
    step: step
    varStatus: iteration status obj
      index: from 0
      count: from 1

--%>

<%

  List list = new ArrayList();

  list.add("Sheldon");
  list.add("Leonard");
  list.add("Amy");

  request.setAttribute("list",list);
%>

<c:forEach items="${list}" var="name" varStatus="s">
  ${s.index} ${s.count} ${name}<br>
</c:forEach>

</body>
</html>
