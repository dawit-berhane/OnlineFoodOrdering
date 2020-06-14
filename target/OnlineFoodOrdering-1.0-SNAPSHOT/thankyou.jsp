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
<div class="backtohome">
    <a href="index.jsp"> Home </a>
</div>
<div class="jumbotron">
    <h1 class="display-4"> Thank you!</h1>
    <p class="lead">We hope to see you again.</p>
    <hr class="my-4">
    <p></p>
    <a class="btn btn-primary btn-lg" href="#" role="button">Login again</a>
</div>
</body>
</html>