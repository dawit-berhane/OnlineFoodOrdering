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
</head>
<body>
<h1>Menu Page</h1>
Welcome ${userName}
<div>
    <table>
        <tr>
            <td><img src="resources/images/burger.jpg" alt="burger"></td>
            <td>Burger made with beef and cheese</td>
            <td><button id="burger" type="button">Add</button></td>
        </tr>
        <tr>
            <td><img src="resources/images/steak.jpg" alt="steak"></td>
            <td>Steak with rice</td>
            <td><button id="steak" type="button">Add</button></td>
        </tr>
        <tr>
            <td><img src="resources/images/fish.jpg" alt="fish"></td>
            <td>grilled fish</td>
            <td><button id="fish" type="button">Add</button></td>
        </tr>
    </table>
</div>
</body>
</html>
