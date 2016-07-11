<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>World Database Signup</title>
<link rel="stylesheet" href="styles/kendo.common.min.css" />
<link rel="stylesheet" href="styles/kendo.default.min.css" />
<link rel="stylesheet" href="styles/bootstrap.min.css" />
<link rel="stylesheet" href="css/login.css" />
<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script>
</head>
<body>
	<form action="SignupController" method="post">
		<div id="pagewrap">
			<div class="wrapper row1">
				<div class="col">
					<h2 id="headingpanel"> Sign up Here</h2>
				</div>
			</div>
			<div class="demo-section k-content">
				<div class="row1">
					<div class="col">
						<label> FirstName </label>
						<kendo:maskedTextBox name="FirstName"></kendo:maskedTextBox>
					</div>
					<div class="col">
						<label> LastName </label>
						<kendo:maskedTextBox name="LastName"></kendo:maskedTextBox>
					</div>

					<div class="col">
						<label> Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>
						<kendo:maskedTextBox name="Email"></kendo:maskedTextBox>
					</div>


					<div class="col">
						<label> Password </label>
						<kendo:maskedTextBox name="Password" type="password"></kendo:maskedTextBox>
					</div>
					
					<div class="col">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<kendo:button name="register" tag="a" enable="true" class="k-primary">
						<kendo:button-content>Register</kendo:button-content>
					</kendo:button>
		
					<div>
						<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="Login.jsp">
							Login </a>



					</div>

				</div>
			</div>


		</div>



	</form>
</body>
</html>