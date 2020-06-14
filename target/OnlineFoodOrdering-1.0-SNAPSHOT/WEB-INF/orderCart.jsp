<%--
  Created by IntelliJ IDEA.
  User: Moss21k
  Date: 6/13/20
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Cart</title>
</head>
<body>
<table id="tbl_products">
    <thead>
    <tr>
        <th>Selected Foods</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.id}" /></td>
            <td><c:out value="${product.name}" /></td>
            <td><c:out value="${product.price}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
