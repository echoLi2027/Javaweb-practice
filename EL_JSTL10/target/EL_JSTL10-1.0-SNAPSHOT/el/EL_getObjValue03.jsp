<%@ page import="domain.User" %>
<%@ page import="java.util.*" %><%--
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
    User user = new User();
    user.setUsername("sheldon");
    user.setPassword("123");
    user.setBirthday(new Date());

    request.setAttribute("user", user);

    List list = new ArrayList();
    list.add("str1");
    list.add("str2");
    list.add(user);

    request.setAttribute("list", list);

    Map map = new HashMap();
    map.put("m-name","Leonard");
    map.put("gender","male");
    map.put("user", user);

    request.setAttribute("map", map);


%>

<h3>el get value from obj</h3>

user obj:${requestScope.user}<br>

<%--el get attr of an obj via getter--%>
username:${requestScope.user.username}<br>
password:${requestScope.user.password}<br>
birthday original format:${requestScope.user.birthday}<br>
birthday month:${requestScope.user.birthday.month}<br>

birthday strict format:${requestScope.user.birStr}<br>

<h3>el get value from list</h3>

list:${requestScope.list}<br>

list no.1 :${requestScope.list[0]}<br>

<%--out of length, don't show--%>
list no.10 :${requestScope.list[9]}<br>


list no.3's username attr :${requestScope.list[2].username}<br>

<h3>el get value from map</h3>

map:${requestScope.map}<br>

map value of key m-name:${requestScope.map["m-name"]}<br>


map of username attr :${requestScope.map.user.username}<br>




</body>
</html>
