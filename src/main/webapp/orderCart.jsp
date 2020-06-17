<%@ page import="com.online.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Moss21k
  Date: 6/13/20
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Cart</title>
    <link href="resources/css/basic.css" type="text/css" rel="stylesheet">
    <link href="resources/css/menu.css" type="text/css" rel="stylesheet">
    <title>Menu</title>
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/menu.js"></script>
    <script type="text/javascript" src="resources/js/cart.js"></script>
</head>
<body>
<nav id="top">
    <span> <a href="menu.jsp">Go to menu Page</a></span>
    <span> <a href="login.jsp"> Logout</a></span>
</nav>
<table id="checkoutTable">
    <thead>
    <tr>
        <th>Selected Foods</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${checkout}" var="checkout">
        <tr>
            <td><c:out value="${checkout.id}" /></td>
            <td><c:out value="${checkout.name}" /></td>
            <td><c:out value="$${checkout.price}" /></td>
        </tr>
    </c:forEach>

        <tr>

            <td colspan="2">Total</td>
            <td>$
                <%
                List<Product> menu = new ArrayList<>();
                menu = (List<Product>) session.getAttribute("checkout");
                int val = 0;
                for (Product p: menu
                ) {
                    val += p.getPrice();

                }
            %>
                <%= val%> </td>

        </tr>


    </tbody>
</table>
<button id="payBtn">Pay</button>
<p> The food will be delivered to your Address: ${address}</p>
<p id="success_msg" ></p>


</body>
</html>
