<%@ page import="core.dto.model.shoppingcart.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="core.dto.model.catalog.product.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="core.dto.model.catalog.product.ProductAttribute" %>
<%@ page import="core.daoimpl.factory.DAOFactory" %>
<%@ page import="core.dao.catalog.product.ProductAttributeDao" %>
<%@ page import="core.dto.model.customer.Customer" %>
<%@ page import="core.dao.shopping_cart.ShoppingCartDao" %>
<%@ page import="core.dao.catalog.product.ProductDao" %><%--
  Created by IntelliJ IDEA.
  User: DucBa
  Date: 2/25/2018
  Time: 2:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //attribute processing
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ProductAttributeDao productAttributeDao = daoFactory.getProductAttributeDao();
    ProductDao productDao = daoFactory.getProductDao();
    List<ProductAttribute> listProductAttribute = new ArrayList<>();

    //product detail processing
    int indexProduct = 0;
    Product product = null;
    if (session.getAttribute("listProduct") != null && request.getParameter("index") != null) {
        List<Product> listProduct = (ArrayList<Product>) session.getAttribute("listProduct");
        product = listProduct.get(Integer.parseInt(request.getParameter("index")));
        listProductAttribute = productAttributeDao.getByProductId(product.getId());
    }

    //recommend product processing
    List<Product> listRecommend = null;
    if (product != null) {
        listRecommend = productDao.getListRecommend(product.getId());

    }

    //customer processing
    Customer customer = null;
    if (session.getAttribute("customer") != null) {
        customer = (Customer) session.getAttribute("customer");
        session.setAttribute("customer", customer);
    }

    //shopping cart processing
    ShoppingCart shoppingCart = null;
    if (session.getAttribute("shoppingCart") != null) {
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        System.out.println("Co san cart");
    } else {
        shoppingCart = new ShoppingCart();
        session.setAttribute("shoppingCart", shoppingCart);
    }
%>

<jsp:include page="header.jsp"></jsp:include>
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-1">
            </div>

            <div class="col-sm-9 padding-right">
                <div class="product-details"><!--product-details-->
                    <div class="col-sm-5">
                        <div class="view-product">
                            <img src="<%=product.getThumbai()%>" alt=""/>
                            <h3>ZOOM</h3>
                        </div>
                        <div id="similar-product" class="carousel slide" data-ride="carousel">

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
                                    <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
                                    <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
                                </div>
                                <div class="item">
                                    <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
                                    <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
                                    <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
                                </div>
                                <div class="item">
                                    <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
                                    <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
                                    <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
                                </div>

                            </div>

                            <!-- Controls -->
                            <a class="left item-control" href="#similar-product" data-slide="prev">
                                <i class="fa fa-angle-left"></i>
                            </a>
                            <a class="right item-control" href="#similar-product" data-slide="next">
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </div>

                    </div>
                    <div class="col-sm-7">
                        <div class="product-information"><!--/product-information-->
                            <img src="images/product-details/new.jpg" class="newarrival" alt=""/>
                            <h2><%=product.getName()%>
                            </h2>
                            <span>
									<span>US $<%=product.getPrice()%></span>
									<label>Quantity:</label>
                                    <input value="<%=product.getId()%>" type="hidden" id="productId">
									<input type="number" value="1" id="quantity"/>

                                    <a id='addToCart'
                                    <%--href="../../ShoppingCartController?productId=<%=product.getId()%>&quantity=1&command=plus"--%>
                                       onclick="addToCart()">
                                        <i class="fa fa-shopping-cart"></i>
                                        Add to cart
                                    </a>
								</span>
                            <p><b>Availability:</b> In Stock</p>
                            <p><b>Color:</b>
                                <select id="attribute">
                                    <%
                                        int quan = 0;
                                        for (ProductAttribute productAttribute : listProductAttribute) {
                                            quan = productAttribute.getAmount();
                                    %>

                                    <option value="<%=productAttribute.getAttribute().getName()%>"><%=productAttribute.getAttribute().getName()%>


                                    </option>

                                    <%}%>
                                </select>
                                <input value="<%=quan%>" type="hidden" id="quantityStock">

                            </p>
                            <a href=""><img src="images/product-details/share.png" class="share img-responsive" alt=""/></a>
                        </div><!--/product-information-->
                    </div>
                </div><!--/product-details-->


                <div class="recommended_items"><!--recommended_items-->
                    <h2 class="title text-center">recommended items</h2>

                    <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="item active">
                                <%
                                    for (Product product1 : listRecommend) {
                                %>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="<%=product1.getThumbai()%>" alt=""/>
                                                <h2><%=product1.getPrice()%>
                                                </h2>
                                                <p><%=product1.getName()%>
                                                </p>
                                                <button type="button" class="btn btn-default add-to-cart"><i
                                                        class="fa fa-shopping-cart"></i>Add to cart
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <%
                                    }
                                %>

                            </div>
                        </div>
                    </div>
                </div><!--/recommended_items-->

            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<script>

    // $('#attribute').on('change', function () {
    //     var attribute = $(this).val();
    //     var productId = $('#productId').val();
    //     var quantity = $('#quantity').val();
    //     $('#addToCart').prop('href', '../../ShoppingCartController?productId=' + productId +
    //                         '&quantity=' + quantity + '&attribute=' + attribute + '&command=plus');
    // });

    function addToCart() {
        var attribute = $('#attribute').val();
        var quantityStock = parseInt($('#quantityStock').val());
        var productId = $('#productId').val();
        var quantity = $('#quantity').val();
        alert('So luong mua ' + quantity);
        alert('So luong trong kho ' + quantityStock);
        if (quantityStock < quantity) {
            alert('San pham thieu so luong trong kho');

        } else {
            alert('Them thanh cong');
            $('#addToCart').prop('href', '../../ShoppingCartController?productId=' + productId +
                '&quantity=' + quantity + '&attribute=' + attribute + '&command=plus');
        }
    }


</script>