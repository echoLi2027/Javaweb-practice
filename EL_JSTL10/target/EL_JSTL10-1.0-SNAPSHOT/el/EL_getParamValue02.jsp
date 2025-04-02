<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhouziyan
  Date: 02.04.25
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>values</title>
</head>
<body>

<%
    session.setAttribute("name", "session");

    request.setAttribute("name","request");

    session.setAttribute("age","23");

    request.setAttribute("str","");
%>

<h3>el get value</h3>
${sessionScope.name}<br>

${sessionScope.age}<br>

<%--if there is no such value, jsp won't throw an exception, just don't show the value--%>
${sessionScope.gender}<br>

${requestScope.name}<br>




</body>
</html>
