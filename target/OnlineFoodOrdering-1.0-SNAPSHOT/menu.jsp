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
    <link href="resources/css/basic.css" type="text/css" rel="stylesheet">
    <title>Menu</title>
</head>
<body>
<div class="backtohome">
    <a href="index.jsp">  Home </a>
</div>
<h1>Menu Page</h1>
Welcome ${userName}
<div>
    <table>
        <tr>
            <th>Menu</th>
            <th>Ingredient</th>
            <th>Price</th>
            <th>Order</th>
        </tr>
        <tr>
            <td><img src="resources/images/burger.jpg" alt="burger"></td>
            <td>Burger made with beef and cheese</td>
            <td>$6</td>
            <td><button id="burger" type="button">Add</button></td>
        </tr>
        <tr>
            <td><img src="resources/images/steak.jpg" alt="steak"></td>
            <td>Steak with rice</td>
            <td>$12</td>
            <td><button id="steak" type="button">Add</button></td>
        </tr>
        <tr>
            <td><img src="resources/images/fish.jpg" alt="fish"></td>
            <td>grilled fish</td>
            <td>$20</td>
            <td><button id="fish" type="button">Add</button></td>
        </tr>
    </table>
</div>
</body>
</html>
