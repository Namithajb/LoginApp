
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main1.css">
<script src="js/custom.js" type="text/javascript"></script>
<title>Login</title>

</head>
<body>
	<div class="container-contact100">
		<div class="wrap-contact100">
			<span class="contact100-form-title"> Login User </span>
			<form:form method="post" id="loginForm" modelAttribute="login"
				action="login">
				
			 <div>	<c:if test ="${param.error}"> 
			     Invalid username and password.</c:if></div>
		   <div>	<c:if test="${param.logout}"> 
                    You have been logged out.</c:if> </div>
              
				
				
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your User Name">
					<form:input path="username" name="username" id="username" placeholder="User Name" class="input100" />
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Password">
					<form:password path="password" name="password" id="password" placeholder="Password" class="input100" />
				</div>
				<div class="container-contact100-form-btn">
					<button>
						<span> <form:button id="login" name="login"
								class="contact100-form-btn">Login</form:button>
						</span>
						<span class="contact100-form-message"> ${errorMessage} </span>
				<div class="container-contact100-form-btn">
					</button>
				</div>

				<span class="contact100-form-title"> <a href="/">Home</a></span>
			</form:form>
			<table align="center">
				<tr>
					<td style="font-style: italic; color: red;">${message}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
