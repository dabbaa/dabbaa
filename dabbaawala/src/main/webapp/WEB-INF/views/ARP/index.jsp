<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--css-->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/style/style.css">
    <!--script-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<h3 align="Center">Login</h3>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">
            <c:choose>
            	<c:when test="${not empty ErrorMsg}">
					${ErrorMsg}
					Please authenticate to the system
				</c:when>
	            <c:otherwise>
	            	Please authenticate to the system
	            </c:otherwise>
            </c:choose>
            </h1>
            <div class="account-wall">
                <img class="profile-img" src="resources/image/APR_Logo.gif" alt="ARP Enterprises">
                <form class="form-signin" method="post" action="login">
                    <input type="text" class="form-control" name="userName" placeholder="User Name" required autofocus>
                    <input type="password" class="form-control" name="userPassword" placeholder="Password" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">LogIn</button>
                    <label class="checkbox pull-left">
                        <input type="checkbox" value="remember-me">
                        Remember me
                    </label>
                    <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="#" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>

</body>
</html>
