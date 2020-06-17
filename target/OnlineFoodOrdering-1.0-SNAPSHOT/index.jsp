<%--
  Created by IntelliJ IDEA.
  User: Dawit
  Date: 6/13/20
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name=viewport content="width=device-width, initial-scale=1">
  <meta name="description" content="Response design">
  <meta name="author" content="bootstrap">
  <link href="resources/css/basic.css" type="text/css" rel="stylesheet">
  <jsp:include page="resources.jsp"></jsp:include>
    <link href="resources/css/grid.css" type="text/css" rel="stylesheet">
  <title>Home Page</title>
</head>
<body>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

%>
<div class="base">

  <header>
    <h3>Welcome to Online Food Ordering System</h3>
  </header>

  <div class="menu row">
    <div class="col-2 col-md-2 col-lg-1"><a href="login.jsp">Login</a></div>
    <div class="col-2 col-md-2 col-lg-1"><a href="menu.jsp"> Menu</a></div>
    <div class="col-2 col-md-2 col-lg-1"><a href="login.jsp"> Admin</a></div>
    <div class="col-2 col-md-2 col-lg-1"><a href="signup.jsp">sign up</a></div>
    <div class="col-2 col-md-2 col-lg-1"><a href="logout.jsp">Log out</a></div>
  </div>

  <div class="row">
    <div id="col1" class="col-6 col-md-4 col-lg-4"><img src="resources/images/dinning.jpg" width="1300" class="img-fluid" alt="Responsive image"></div>
    <div id="col2" class="col-6 col-md-4 col-lg-4"><img src="resources/images/weekend.jpeg" height="300" width="450"  class="img-fluid" alt="Responsive image"></div>
    <div id="col3" class="col-12 col-md-4 col-lg-4"><img src="resources/images/hours.jpeg"  class="img-fluid" alt="bar" height="300" width="450"></div>
  </div>
  <footer>
      <div class="fixed">
       <p>Chat with us</p>
      </div>

  </footer>
</div>

</body>
</html>











