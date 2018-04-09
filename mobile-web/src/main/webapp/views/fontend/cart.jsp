<%@ page import="core.dto.model.shoppingcart.ShoppingCart" %>
<%@ page import="core.dto.model.shoppingcart.ShoppingCartItem" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="core.dto.model.customer.Customer" %><%--
  Created by IntelliJ IDEA.
  User: nbduc
  Date: 3/7/2018
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    //shopping cart processing
    ShoppingCart shoppingCart = null;
    if (session.getAttribute("shoppingCart") != null) {
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
    }
    session.setAttribute("shoppingCart", shoppingCart);

    //customer processing
    Customer customer = null;
    if (session.getAttribute("customer") != null) {
        customer = (Customer) session.getAttribute("customer");
        session.setAttribute("customer", customer);
    }
%>


<jsp:include page="header.jsp"></jsp:include>

<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">Item</td>
                    <td class="description"></td>
                    <td class="price">Price</td>
                    <td class="quantity">Quantity</td>
                    <td class="quantity">Attribute</td>
                    <td class="total">Total</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>


                <%
                    HashMap<Integer, ShoppingCartItem> cart = shoppingCart.getShoppingCart();
                    Set<Map.Entry<Integer, ShoppingCartItem>> entries = cart.entrySet();
                    for (Map.Entry<Integer, ShoppingCartItem> entry : entries) {
                %>

                <tr>
                    <td class="cart_product">
                        <a href=""><img src="<%=entry.getValue().getProduct().getThumbai()%>" alt=""></a>
                    </td>
                    <td class="cart_description">
                        <h4><a href=""><%=entry.getValue().getProduct().getName()%>
                        </a></h4>
                    </td>
                    <td class="cart_price">
                        <p>$<%=entry.getValue().getProduct().getPrice()%>
                        </p>
                    </td>
                    <td class="cart_quantity">
                        <div class="cart_quantity_button">
                            <p><%=entry.getValue().getQuantity()%>
                            </p>
                        </div>
                    </td>

                    <td class="cart_attribute">
                        <p><%=entry.getValue().getAttribute()%>
                        </p>
                    </td>

                    <td class="cart_total">
                        <p class="cart_total_price">$59</p>
                    </td>
                    <td class="cart_delete">
                        <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</section> <!--/#cart_items-->
<a href="#" style="margin: 400px">Remove all</a>
<a href="../../ShoppingCartController?command=save">Save for later</a>

    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
