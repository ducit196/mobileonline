<%@ page import="core.daoimpl.factory.DAOFactory" %>
<%@ page import="core.dto.model.customer.Customer" %>
<%@ page import="core.dto.model.shoppingcart.ShoppingCart" %>
<%@ page import="core.dao.shopping_cart.ShoppingCartDao" %>
<%@ page import="core.dto.model.shoppingcart.ShoppingCartItem" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: DucBa
  Date: 2/25/2018
  Time: 2:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    //customer processing
    Customer customer = null;
    if (session.getAttribute("customer") != null) {
        customer = (Customer) session.getAttribute("customer");
        session.setAttribute("customer", customer);
        System.out.println("Customer đéo null");
    }

    //shopping cart processing
    ShoppingCart shoppingCart = null;
    if (session.getAttribute("shoppingCart") != null) {
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        System.out.println("Co roi");
    } else if (customer != null) {
        ShoppingCartDao shoppingCartDao = daoFactory.getShoppingCartDao();
        shoppingCart = shoppingCartDao.getByCustomerId(customer.getId());
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        System.out.println("Lay tu db");
    } else {
        shoppingCart = new ShoppingCart();
        session.setAttribute("shoppingCart", shoppingCart);
        System.out.println("Chua co");
    }

%>


<jsp:include page="header.jsp"></jsp:include>

<section id="cart_items">
    <div class="container">

        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">Item</td>
                    <td class="description"></td>
                    <td class="price">Price</td>
                    <td class="quantity">Quantity</td>
                    <td>Attribute</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>

                <%
                    float total = 0;
                    HashMap<Integer, ShoppingCartItem> cart = shoppingCart.getShoppingCart();
                    Set<Map.Entry<Integer, ShoppingCartItem>> entries = cart.entrySet();
                    for (Map.Entry<Integer, ShoppingCartItem> entry : entries) {
                        total += entry.getValue().getProduct().getPrice() * entry.getValue().getQuantity();
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
                        <p><%=entry.getValue().getProduct().getPrice()%>
                        </p>
                    </td>
                    <td class="cart_quantity">
                        <%=entry.getValue().getQuantity()%>
                    </td>
                    <td>
                        <%=entry.getValue().getAttribute()%>
                    </td>
                    <td class="cart_delete">
                        <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                    </td>
                </tr>
                <%}%>

                <tr>
                    <td colspan="4">&nbsp;</td>
                    <td colspan="2">
                        <table class="table table-condensed total-result">
                            <tr>
                                <td>Total</td>
                                <td><span>$<%=total%></span></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <a href="../../OrderController" style="text-align: center">Đặt hàng</a>
    </div>
</section> <!--/#cart_items-->

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
