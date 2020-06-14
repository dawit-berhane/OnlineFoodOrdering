<%--
  Created by IntelliJ IDEA.
  User: mesfindejene
  Date: 2020-06-13
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up</title>
    <jsp:include page="resources.jsp"></jsp:include>
</head>
<body>
<div id="signup">
    <div class="container">
        <h3>SignUp</h3>
        <c:if test="${not empty error}" >${error}</c:if>

        <form class="formValidator" method="post" action="signup">

            <div class="form-row">

                <div class="form-group col-md-6">
                    <label for="fname">First Name: </label> <input type="text" class="form-control" id="fname" placeholder="Enter First name.." name="fname">
                </div>

                <div class="form-group col-md-6">
                    <label for="lname">Last Name: </label> <input type="text" class="form-control" id="lname" placeholder="Enter Last Name.." name="lname">
                </div>


                <div class="form-group col-md-6">
                    <label for="userame">User Name: </label> <input type="text" class="form-control" id="userame" placeholder="Enter user name.." name="userName">
                </div>


                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label> <input type="password" class="form-control" id="inputPassword4" name="password">
                </div>
                <div class="form-group">
                    <label for="cpwd">Confirm Password:<input type="password" class="form-control" id="cpwd" placeholder="Confirm password.." name="cpassword"></label>
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Address 2</label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">City</label>
                    <input type="text" class="form-control" id="inputCity">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputState">State</label>
                    <select id="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputZip">Zip</label>
                    <input type="text" class="form-control" id="inputZip">
                </div>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Check me out
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form>
    </div>
</div>
</body>
</html>
