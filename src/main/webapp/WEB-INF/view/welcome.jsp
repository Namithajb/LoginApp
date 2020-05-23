
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main1.css">
</head>
<body>
	<div class="container-contact100">
		<div class="wrap-contact100">
			<!-- <a href="showLoginPage">Login</a> <a href="showRegistrationPage">Registration</a> -->
			<div class="container-contact100-form-btn">
				<button>
					<span>
					<%-- <c:url value="/logout" var="logoutUrl" /> --%>
					
						<button id="logout" name="logout" class="contact100-form-btn" 
							onclick="location.href = 'logout';">Sign Out</button>
					</span>
				</button>
			</div>
			<div class="container-contact100-form-btn">
				<button>
					<span>
						<button id="Invoice" name="invoice" class="contact100-form-btn"
							onclick="location.href = 'invoiceProcess';">Invoice
							Generation</button>
					</span>
				</button>
			</div>

			<div class="container-contact100-form-btn">
				<button>
					<span>
						<button id="Invoicelist" name="invoicelist"
							class="contact100-form-btn"
							onclick="location.href = 'getInvoice';">List Invoice</button>
					</span>
				</button>
			</div>
		</div>
	</div>
</body>
</html>