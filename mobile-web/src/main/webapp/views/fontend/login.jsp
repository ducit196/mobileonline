<%--
  Created by IntelliJ IDEA.
  User: DucBa
  Date: 2/25/2018
  Time: 2:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <section id="form"><!--form-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-1">
                    <div class="login-form"><!--login form-->
                        <h2>Login to your account</h2>
                        <form method="POST" action="../../LoginController">
                            <input type="text" placeholder="Username" name="username"/>
                            <input type="password" placeholder="Password" name="password"/>
                            <button type="submit" class="btn btn-default">Login</button>
                        </form>
                    </div><!--/login form-->
                </div>
            </div>
        </div>
    </section><!--/form-->

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
