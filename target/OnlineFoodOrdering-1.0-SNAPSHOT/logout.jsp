<%--
  Created by IntelliJ IDEA.
  User: mesfindejene
  Date: 2020-06-15
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log out</title>
    <jsp:include page="resources.jsp"></jsp:include>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);

%>
<div id="login">
    <div class="container bg-info">

        <h3>Log out</h3>
        <form class=" bg-info" action="logout">

            <div class="form-group col-md-6">
                <p> Are you sure you want to log out? </p>
                <label>
                    <button type="submit">Log out</button>
                </label>
            </div>

        </form>
    </div>
</div>
</body>
</html>


