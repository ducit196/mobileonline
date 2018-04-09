<%@ page import="core.daoimpl.factory.DAOFactory" %>
<%@ page import="core.dao.catalog.product.ProductDao" %>
<%@ page import="core.dto.model.catalog.product.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="core.dao.catalog.category.CategoryDao" %>
<%@ page import="core.dto.model.catalog.category.Category" %>
<%@ page import="core.dto.model.shoppingcart.ShoppingCart" %>
<%@ page import="core.dto.model.customer.Customer" %><%--
  Created by IntelliJ IDEA.
  User: nbduc
  Date: 3/21/2018
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%

    //category and product processing
    int categoryId = 0;
    if (request.getParameter("categoryId") != null) {
        categoryId = Integer.parseInt(request.getParameter("categoryId"));
    }
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ProductDao productDao = daoFactory.getProductDao();
    CategoryDao categoryDao = daoFactory.getCategoryDao();
    List<Product> listProduct = productDao.getByCategoryId(categoryId);
    Category category = categoryDao.getById(categoryId);
    session.setAttribute("listProduct", listProduct);

    //shopping cart processing
    ShoppingCart shoppingCart = null;
    if (session.getAttribute("shoppingCart") != null) {
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
    } else {
        shoppingCart = new ShoppingCart();
        session.setAttribute("shoppingCart", shoppingCart);
    }

    //customer processing
    Customer customer = null;
    if (session.getAttribute("customer") != null) {
        customer = (Customer) session.getAttribute("customer");
        session.setAttribute("customer", customer);
    }


%>

<div class="features_items"><!--features_items-->
    <h2 class="title text-center"><%=category.getCategoryName()%>
    </h2>

    <%
        int i = 0;
        for (Product product : listProduct) {
    %>

    <div class="col-sm-3">
        <div class="product-image-wrapper">
            <div class="single-products">
                <div class="productinfo text-center">
                    <img src="<%=product.getThumbai()%>" alt=""/>
                    <h2>$<%=product.getPrice()%>
                    </h2>
                    <p><%=product.getName()%>
                    </p>
                </div>
            </div>
            <div class="choose">
                <ul class="nav nav-pills nav-justified">
                    <li><a href="../../ShoppingCartController?productId=<%=product.getId()%>&quantity=1&command=plus"><i
                            class="fa fa-plus-square"></i>Add to cart</a></li>
                    <li><a href="product_detail.jsp?index=<%=i%>"><i class="fa fa-plus-square"></i>View detail</a></li>
                </ul>
            </div>
        </div>
    </div>
    <%
            i++;
        }
    %>

</div><!--features_items-->


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
