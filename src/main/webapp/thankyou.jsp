<%--
  Created by IntelliJ IDEA.
  User: mesfindejene
  Date: 2020-06-13
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="resources/css/basic.css" type="text/css" rel="stylesheet">
    <title>thank you</title>
    <jsp:include page="resources.jsp"></jsp:include>
</head>
<body>

<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);

    if(session.getAttribute("userName")==null)
        response.sendRedirect("login.jsp");
%>

<div class="jumbotron bg-info">
    <h3 class="display-4"> you are logged out!</h3>
    <p class="lead">Thank you ! We hope to see you again.</p>
    <hr class="my-4">
    <p></p>
    <a class="btn btn-primary btn-lg" href="login.jsp" role="button">Login again</a></a>
</div>
</body>
</html>