<%--
  Created by IntelliJ IDEA.
  User: Prateek
  Date: 18-11-2022
  Time: 05:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TCS CBT Dashboard</title>
</head>
<body>

<% // JSP code | will be compiled into HTML before being sent out as response
    String username = (String) request.getSession(false).getAttribute("username"); // Java Statememt
%>

<h3>Welcome <%= username %></h3>

</body>
</html>
