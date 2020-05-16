<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main1.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>

  <script>
 $(function(){
	 
 $("#regForm").validate({
	 
rules:{
	username:"required",
password:{
	required:true,
	minlength:8
},

firstname:"required",
lastname:"required",
email:{
	required:true,
	email:true
},
address:"required",
phone:"required"
},
 messages: {
	  username:"Please enter username",
	  password:{minlength:'Password must be at least 8 characters long'},
      firstname: "Please enter your firstname",
      lastname: "Please enter your lastname",
      email:"Enter a valid email",
      address:"Please enter address",
      phone:"Please enter phone no"
 },

 });
}); 
 </script> 



<title>Registration</title>
</head>
<body>
	<div class="container-contact100">
		<div class="wrap-contact100">
			<span class="contact100-form-title"> Register User </span>
			<form:form id="regForm" modelAttribute="user" name="regForm" 
				action="registrationProcess" method="POST"
				class="contact100-form validate-form">

				<div class="wrap-input100 validate-input" id="id1"
					data-validate="Please enter your User Name">
				
					<form:input path="username" name="username" id="username"
						class="input100" placeholder="User Name" />
					<form:errors path="username" cssClass="error" />
        
					
				</div>

				
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Password">
			
					<form:password path="password" name="password" id="password"
						placeholder="Password" class="input100" />

					<form:errors path="password" cssClass="error" />
				</div>

				<div class="wrap-input100 validate-input" id="id2"
					data-validate="Please enter your First Name">
					
					<form:input path="firstname" name="firstname" id="firstname"
						placeholder="First Name" class="input100" />
						<form:errors path="firstname" cssClass="error" />
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Last Name">
						
					<form:input path="lastname" name="lastname" id="lastname"
						placeholder="Last Name" class="input100" />
						<form:errors path="lastname" cssClass="error" />
						
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Email ID">
						
					<form:input path="email" name="email" id="email"
						placeholder="Email" class="input100" />
						<form:errors path="email" cssClass="error" />
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Address">
					
					<form:input path="address" name="address" id="address"
						placeholder="Address" class="input100" />
						<form:errors path="address" cssClass="error" />
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Please enter your Phone Number">
				
					<form:input path="phone" name="phone" id="phone"
						placeholder="Phoneno" class="input100" />
						<form:errors path="phone" cssClass="error" />
				</div>
	<%-- 			<span class="contact100-form-message"> ${message} </span> --%>
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









