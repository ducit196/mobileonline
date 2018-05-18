<%@ page import="core.dto.model.common.Account" %>
<%@ page import="core.dto.model.customer.Customer" %>
<%@ page import="core.daoimpl.factory.DAOFactory" %>
<%@ page import="core.dao.customer.CustomerDao" %>
<%@ page import="core.dto.model.shoppingcart.ShoppingCart" %>
<%@ page import="core.dao.shopping_cart.ShoppingCartDao" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="core.dto.model.shoppingcart.ShoppingCartItem" %><%--
  Created by IntelliJ IDEA.
  User: DucBa
  Date: 2/25/2018
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | Team08 mobile</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">

</head>
<body>

<%
    //account processing
    Account account = null;
    if (session.getAttribute("account") != null) {
        account = (Account) session.getAttribute("account");
    }

    //customer process
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    CustomerDao customerDao = daoFactory.getCustomerDao();
    Customer customer = null;
    if (account != null) {
        customer = customerDao.getByAccountId(account.getId());
        session.setAttribute("customer", customer);
    }

    //shopping cart processing
    ShoppingCart shoppingCart = null;
    if (session.getAttribute("shoppingCart") != null && ((ShoppingCart) session.getAttribute("shoppingCart")).getShoppingCart().size() > 0) {
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        System.out.println("Co san cart");
    } else if (customer != null) {
        ShoppingCartDao shoppingCartDao = daoFactory.getShoppingCartDao();
        shoppingCart = shoppingCartDao.getByCustomerId(customer.getId());
        session.setAttribute("shoppingCart", shoppingCart);
    } else {
        shoppingCart = new ShoppingCart();
        session.setAttribute("shoppingCart", shoppingCart);
        System.out.println("Chua co");

    }
%>

<header id="header"><!--header-->
    <div class="header_top"><!--header_top-->
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="contactinfo">
                        <ul class="nav nav-pills">
                            <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                            <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="social-icons pull-right">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header_top-->

    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="home.jsp"><img src="images/home/logo.png" alt=""/></a>
                    </div>
                    <div class="btn-group pull-right">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                USA
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Canada</a></li>
                                <li><a href="#">UK</a></li>
                            </ul>
                        </div>

                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                DOLLAR
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Canadian Dollar</a></li>
                                <li><a href="#">Pound</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">
                            <%
                                if (account != null) {
                            %>
                            <li><a href="#"><i class="fa fa-user"></i> <%=account.getUsername()%>
                            </a></li>
                            <%} else {%>
                            <li><a href="#"><i class="fa fa-user"></i> Account </a></li>
                            <%}%>
                            <li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
                            <li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i> Order</a></li>
                            <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                            <%
                                if (account != null) {
                            %>
                            <li><a href="../../LogoutController"><i class="fa fa-lock"></i> Logout</a></li>
                            <%} else {%>
                            <li><a href="login.jsp"><i class="fa fa-lock"></i> Login</a></li>
                            <%}%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-middle-->

    <div class="header-bottom"><!--header-bottom-->
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="mainmenu pull-left">
                        <ul class="nav navbar-nav collapse navbar-collapse">
                            <li><a href="home.jsp" class="active">Home</a></li>
                            <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="shop.jsp">Products</a></li>
                                    <li><a href="product-details.jsp">Product Details</a></li>
                                    <li><a href="checkout.jsp">Checkout</a></li>
                                    <li><a href="cart.jsp">Cart</a></li>
                                    <li><a href="login.jsp">Login</a></li>
                                </ul>
                            </li>
                            <li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="blog.jsp">Blog List</a></li>
                                    <li><a href="blog-single.jsp">Blog Single</a></li>
                                </ul>
                            </li>
                            <li><a href="404.jsp">404</a></li>
                            <li><a href="contact-us.jsp">Contact</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="search_box pull-right">
                        <input type="text" placeholder="Search"/>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-bottom-->
</header><!--/header-->

<section id="advertisement">
    <div class="container">
        <img src="images/shop/advertisement.jpg" alt="" />
    </div>
</section>

</body>
</html>
