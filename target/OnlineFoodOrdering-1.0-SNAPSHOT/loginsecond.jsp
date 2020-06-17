<%--
  Created by IntelliJ IDEA.
  User: mesfindejene
  Date: 2020-06-15
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link href="resources/css/basic.css" type="text/css" rel="stylesheet">
    <jsp:include page="resources.jsp"></jsp:include>
</head>
<body>
<div id="login">
    <div class="container bg-info">

        <h3>Log in</h3>

        <form class="formValidator bg-info" method="post" action="menu">
            <div class="form-row bg-info">
                <p style="color: red"> we have your information in file. please log in here</p>
                <div class="form-group col-md-6">
                    <label>User Name: </label> <input type="text" class="form-control"  placeholder="Enter username.." value="${cookie.user.value}" name="userName">
                </div>
                <div class="form-group col-md-6">
                    <label>Password: </label> <input type="password" class="form-control" placeholder="password.." name="password">
                </div>
                <label>
                    <button type="submit">Log in</button>
                </label>
            </div>
        </form>
        <form action="signup" method="post">
            <p>don't have an account? </p>
            <label>
                <button type="button"> <a href="signup.jsp">sign up</a></button>
            </label>
        </form>

    </div>
</div>
</body>
</html>