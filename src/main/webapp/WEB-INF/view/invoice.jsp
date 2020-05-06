<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main1.css">
<title>Generate Invoice</title>
<script>
	function totalPurchase() {
		var p_price = document.getElementById("p_price").value;
		var no_of_part = document.getElementById("no_of_part").value
		var total_price = p_price * no_of_part;
		var vat = document.getElementById("vat").value;
		var total_vat = vat * no_of_part
		var total_amt = parseInt(total_vat) + parseInt(total_price);
		document.getElementById("total_price").value = total_price;
		document.getElementById("total_vat").value = total_vat;
		document.getElementById("total_amt").value = total_amt;
	}
</script>
</head>
<body>
	<div class="container-contact100">
		<div class="wrap-contact100">
			<span class="contact100-form-title"> Create Invoice </span>
			<form:form id="invoiceForm" modelAttribute="invoice"
				action="invoiceProcess" method="POST"
				class="contact100-form validate-form">

				<div class="wrap-input100 validate-input"
					data-validate="Please enter Purchase price">
					<%-- <form:label path="p_price">Purchase Price</form:label> --%>
					<form:input path="p_price" name="p_price" id="p_price"
						class="input100" placeholder="Purchase Price" />

				</div>

				<form:errors path="p_price" />
				<div class="wrap-input100 validate-input"
					data-validate="Please enter Vat">
					<%-- <form:label path="vat">Vat</form:label> --%>
					<form:input path="vat" name="vat" id="vat" placeholder="Vat"
						class="input100" />

					<form:errors path="vat" />
				</div>

				<div class="wrap-input100" data-validate="Please enter No of Parts">
					<%-- <form:label path="no_of_part">Number of Parts</form:label> --%>
					<form:input path="no_of_part" name="no_of_part" id="no_of_part"
						placeholder="No of Parts" class="input100"
						onBlur="totalPurchase()" />
				</div>
				<div class="wrap-input100">
					<%-- <form:label path="total_price">Total Price</form:label> --%>
					<form:input path="total_price" name="total_price" id="total_price"
						placeholder="Total Price" class="input200" readOnly="true" />
				</div>
				<div class="wrap-input100">
					<%-- <form:label path="total_vat">Total Vat</form:label> --%>
					<form:input path="total_vat" name="total_vat" id="total_vat"
						placeholder="Total Vat" class="input200" readOnly="true"
						onBlur="totalPurchase()" />
				</div>
				<div class="wrap-input100 validate-readonly-input">
					<%-- <form:label path="total_amt">Total Amount</form:label> --%>
					<form:input path="total_amt" name="total_amt" id="total_amt"
						placeholder="Total Amount" class="input200"
						onBlur="totalPurchase()" />
				</div>
				<span class="contact100-form-message"> ${message} </span>
				<div class="container-contact100-form-btn">
					<button>
						<span> <form:button id="create" name="create"
								class="contact100-form-btn">Generate Invoice</form:button>
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