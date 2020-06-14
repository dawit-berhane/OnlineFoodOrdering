<%--
  Created by IntelliJ IDEA.
  User: Moss21k
  Date: 6/13/20
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link href="resources/css/basic.css" type="text/css" rel="stylesheet">
</head>
<body>
<form action="menu" method="post">
    <h2>Sign in</h2>
    <label>User Name: <input type="text" name="userName" value="${cookie.user.value}"></label>
    <label>Password: <input type="password" name="password"></label>
    <label><button type="submit">Log in</button></label>
</form>
<span style="color: #ff0000">${error_msg}</span>
</body>
</html>
