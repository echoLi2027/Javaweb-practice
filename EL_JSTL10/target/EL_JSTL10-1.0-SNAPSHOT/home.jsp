<%@ page contentType="text/html; charset=UTF-8" errorPage="500.jsp" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>title</title>
</head>
<body>

<%--jsp default accessible obj--%>

<%
  application.setAttribute("msg","hello");
%>


<%=
  application.getAttribute("msg")
%>
</body>
</html>