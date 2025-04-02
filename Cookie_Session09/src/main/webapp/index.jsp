<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>

<%--jsp script

  1.<%  %>: define java code which shows in the service method.
  2.<%!  %>: define the member variable position
  3.<%= %>: content will display on the webpage
--%>
<%
  Cookie cookie = new Cookie("msg_jsp", "helloJsp");
  response.addCookie(cookie);
  response.getWriter().write(cookie.getValue());
%>

<%!
  int i = 50;
%>

<%=
  "hello jsp...."
%>



<a href="hello-servlet">Hello Servlet</a>

<%
  System.out.println(i);
%>
</body>
</html>