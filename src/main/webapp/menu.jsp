<%--
  Created by IntelliJ IDEA.
  User: Moss21k
  Date: 6/13/20
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <jsp:include page="resources.jsp"></jsp:include>
    <link href="resources/css/basic.css" type="text/css" rel="stylesheet">
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/menu.js"></script>
    <script type="text/javascript" src="resources/js/cart.js"></script>
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

<ul class="nav nav-pills">
    <li class="nav-item">
        <a class="nav-link active" href="index.jsp">home|</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="special.jsp">Deals</a>
    </li>
</ul>
<h1>Menu Page</h1>
Welcome ${userName}
<div>
    <form action="order" method="post">
        <table id="menuTable">
            <tr>
                <th>Menu</th>
                <th>Ingredient</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Order</th>
            </tr>
            <tr>
                <td><img src="resources/images/burger.jpg" alt="burger" width="100" height="100" ></td>
                <td>Burger made with beef and cheese</td>
                <td> <input id="Burger" type="text" maxlength="2" size="2" value="1"> </td>
                <td>$6</td>
                <td><button class=" btn-success btnOrder" type="button" value="Burger">Add</button></td>
            </tr>
            <tr>
                <td><img src="resources/images/steak.jpg" alt="steak" width="100" height="100"></td>
                <td>Steak with rice</td>
                <td> <input type="text" maxlength="2" size="2" value="1"> </td>
                <td>$12</td>
                <td><button class=" btn-success btnOrder" type="button" value="Steak">Add</button></td>
            </tr>
            <tr>
                <td><img src="resources/images/fish.jpg" alt="fish" width="100" height="100"></td>
                <td>grilled fish</td>
                <td> <input type="text" maxlength="2" size="2" value="1"> </td>
                <td>$20</td>
                <td><button class=" btn-success btnOrder" type="button" value="Fish">Add</button></td>
            </tr>
        </table>
    </form>

    <form action="checkout" method="post">
        <table id="orderTbl">
            <thead>
            <tr>
                <th>Menu</th>
                <th>Description</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody >

            </tbody>
        </table>
        <button class="btn-success" id="btnChkout" type="submit">Continue to Checkout</button>
    </form>



</div>
</body>
</html>
