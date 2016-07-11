<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<link rel="stylesheet" href="styles/kendo.common.min.css" />
<link rel="stylesheet" href="styles/kendo.default.min.css" />
<link rel="stylesheet" href="styles/bootstrap.min.css" />
<link rel="stylesheet" href="css/login.css" />
<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script>
</head>
<body>

	<h5>Please enter valid credentials or Sign up again </h5>
	
	<form action="SignupController" method="post">



		<div class="col">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<kendo:button name="signin" tag="a" enable="true" class="k-primary">
				<a href="Signup.jsp"> SignUp </a>
			</kendo:button>

			<div class="col">
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<kendo:button name="signin" tag="a" enable="true" class="k-primary">
					<a href="Login.jsp"> Login </a>

				</kendo:button>
			</div>
		</div>
	</form>
</body>
</html>