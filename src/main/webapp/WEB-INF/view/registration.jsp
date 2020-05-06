<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main1.css">
<title>Registration</title>
</head>
<body>
	<div class="container-contact100">
		<div class="wrap-contact100">
			<span class="contact100-form-title"> Register User </span>
			<form:form id="regForm" modelAttribute="user"
				action="registrationProcess" method="POST"
				class="contact100-form validate-form">

				<div class="wrap-input100 validate-input"
					data-validate="Please enter your User Name">
					<form:input path="username" name="username" id="username"
						class="input100" placeholder="User Name" />
					</td>
				</div>

				<form:errors path="username" />
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Password">
					<form:password path="password" name="password" id="password"
						placeholder="Password" class="input100" />

					<form:errors path="password" />
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Please enter your First Name">
					<form:input path="firstname" name="firstname" id="firstname"
						placeholder="First Name" class="input100" />
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Last Name">
					<form:input path="lastname" name="lastname" id="lastname"
						placeholder="Last Name" class="input100" />
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Email ID">
					<form:input path="email" name="email" id="email"
						placeholder="Email" class="input100" />
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Address">
					<form:input path="address" name="address" id="address"
						placeholder="Address" class="input100" />
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Phone Number">
					<form:input path="phone" name="phone" id="phone"
						placeholder="Phoneno" class="input100" />
				</div>
				<div class="container-contact100-form-btn">
					<button>
						<span> <form:button id="register" name="register"
								class="contact100-form-btn">Register</form:button>
						</span>
					</button>
				</div>
			</form:form>
			<span class="contact100-form-title"> <a href="/">Home</a>
			</span>
		</div>
	</div>
</body>
</html>