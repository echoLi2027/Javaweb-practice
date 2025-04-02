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
    <title>operator</title>
</head>
<body>

${3 > 4}

<%--show el expression originally--%>
\${3 > 4}
<hr>

<h3>arithmetic operator</h3>
${3 + 4}<br>

${3 / 4}<br>
${3 div 4}<br>


${3 % 4}<br>
${3 mod 4}<br>


<h3>comparing operator</h3>
${3 == 4}<br>

<h3>logical operator</h3>
${3 > 4. && 3 < 4}<br>


<h3>empty operator</h3>
<%
    String str = "";
    request.setAttribute("str", str);

    List list = new ArrayList();
    request.setAttribute("list", list);
%>

${not empty str}

${empty list}
</body>
</html>
