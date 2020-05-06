
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
						<button id="sign Out" name="sign out" class="contact100-form-btn"
							onclick="location.href = '/';">Sign Out</button>
					</span>
				</button>
			</div>
			<div class="container-contact100-form-btn">
				<button>
					<span>
						<button id="Invoice" name="invoice" class="contact100-form-btn"
							onclick="location.href = 'invoiceProcess';">Invoice Generation</button>
					</span>
				</button>
			</div>
				</div>
			<div class="container-contact100-form-btn">
				<button>
					<span>
						<button id="Invoicelist" name="invoicelist" class="contact100-form-btn"
							onclick="location.href = 'getInvoice';">Invoice List</button>
					</span>
				</button>
			</div>
		</div>
	</div>
</body>
</html>