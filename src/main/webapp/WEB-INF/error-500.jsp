<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 08/12/16
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.academiadecodigo.HelloWorldWeb" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error 500 - We fucked up!</title>

</head>
<body>
<h2>Sorry mate, we fuck this shit up!</h2>
<ul>
    <li><%=exception.getClass() %></li>
    <li><%=exception.getMessage() %></li>
</ul>
</body>
</html>
