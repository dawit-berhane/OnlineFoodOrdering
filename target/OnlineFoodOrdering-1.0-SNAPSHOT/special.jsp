<%--
  Created by IntelliJ IDEA.
  User: mesfindejene
  Date: 2020-06-17
  Time: 00:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>specials</title>
    <jsp:include page="resources.jsp"></jsp:include>
    <link href="resources/css/specials.css" type="text/css" rel="stylesheet">
    <script src="resources/js/specials.js" type="text/javascript"></script>
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
        <a class="nav-link" href="menu.jsp">menu</a>
    </li>
</ul>


<table id="menuTable">
    <caption><h3>our special deals</h3></caption>
    <tr>
        <td><img src="resources/images/burger.jpg" alt="burger" width="100" height="100"></td>
        <td> Burger made with beef and cheese, Honey Baked Ham <br> One liter coke <br></td>
        <td>$16</td>
        <td>
            <button class="btn btn-success example-popover" type="button" data-toggle="popover" title="Coupon"
                    data-content="dont forget to apply your coupon" id="oneperson">Add
            </button>
        </td>
    </tr>
    <tr>
        <td><img src="resources/images/steak.jpg" alt="steak" width="100" height="100"></td>
        <td>Steak with rice and By the Slice Suppers – <br>
            1/2 pound of sliced ham or turkey, Potatoes Au Gratin, and Kings Hawaiian Rolls
        </td>
        <td>$26.59</td>
        <td>
            <button class="btn btn-success example-popover" type="button" data-toggle="popover" title="Coupon"
                    data-content="dont forget to apply your coupon" id="twopeople">Add
            </button>
        </td>
    </tr>
    <tr>
        <td><img src="resources/images/fish.jpg" alt="fish" width="100" height="100"></td>
        <td>grilled fish and BBQ Roast $34.99 – 3 lb BBQ Pork Roast, Potatoes Au Gratin, <br>
            Green Bean Casserole, and Kings Hawaiian Rolls
        </td>
        <td>$44</td>
        <td>
            <button class="btn btn-success example-popover" type="button" data-toggle="popover" title="Coupon"
                    data-content="dont forget to apply your coupon" id="family">Add
            </button>
        </td>
    </tr>
</table>

<div class="card text-center bg-info">
    <div class="card-header">
        Featured
    </div>
    <div class="card-body">
        <h5 class="card-title">Only for $24.99 </h5>
        <p class="card-text">4 Ham Classic, or 4 Smoked Turkey Classic, or 2 Ham and 2 Turkey sandwiches, 4 bags of Sea
            Salt Deep River Chips</p>
        <a href="#" class="btn btn-success"> Coming soon !</a>
    </div>
    <div class="card-footer text-muted">
        2 days left
    </div>
</div>

<h3> Check your coupon discount</h3>
<div>
    <label><input id="subtotal" type="text" /> $ Subtotal)</label>
</div>

<div class="spinner-border text-danger" role="status">
    <button id="coupon" > Apply coupon</button>
    <span class="sr-only">Loading...</span>
</div>

<div>
    <button id="btn_checkout" >Check out</button>
</div>

<hr/>

<div>
    <h3>Your total:</h3><span> note:  subtotal - 20% coupon + 6.25% tax</span>
    <p id="total">$0.00 </p>
</div>
<div>
    <button id="btnreceipt"> view Order items</button>
</div>
<div>
    <label for="receipt">
        <textarea id="receipt" cols="10" rows="5"></textarea></label>
</div>

</body>
</html>
