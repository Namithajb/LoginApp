<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main1.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
<title>Generate Invoice</title>

<script>
$(function(){
$("#total_price").focus(function()
{
	var a=$("#p_price").val();
	var b=$("#no_of_part").val();
	  var total = a * b;
      $("#total_price").val(total);
	
});
$("#total_vat").focus(function()
		{
			var a=$("#p_price").val();
			var b=$("#vat").val();
			  var total = a * b;
		      $("#total_vat").val(total);
			
		});
$("#total_amt").focus(function()
		{
			var a=$("#total_price").val();
			var b=$("#total_vat").val();
			  var total = parseInt(a) + parseInt(b);
		      $("#total_amt").val(total);
			
		});
	
});

	
</script>








 <script>
 $(function(){
	 $("#invoiceForm").validate({
   rules:
   { p_price:"required",
	   vat:"required",
	   no_of_part:"required"
   },
   messages:
	   {
	   p_price:"Purchase price required",
	   vat:"vat is required",
	   no_of_part:"No of Part required"
	   },
	 });
 });
</script> 
</head>
<body>
<div class="container-contact100">
		<div class="wrap-contact100">
			<span class="contact100-form-title"> Create Invoice </span>
			<form:form id="invoiceForm" modelAttribute="invoice"
				action="/save" method="POST"
				class="contact100-form validate-form">
				
				<div class="wrap-input100 validate-input">
             <form:input path="invoice_id" id="invoice_id" name="invoice_id" class="input100" type="hidden"/></div>
             
				<div class="wrap-input100 validate-input"
					data-validate="Please enter Purchase price">
					<%-- <form:label path="p_price">Purchase Price</form:label> --%>
					<form:errors path="p_price" cssClass="error" />
					<form:input path="p_price" name="p_price" id="p_price"
						class="input100" placeholder="Purchase Price" />

				</div>

				<form:errors path="p_price" />
				<div class="wrap-input100 validate-input"
					data-validate="Please enter Vat">
					<%-- <form:label path="vat">Vat</form:label> --%>
					<form:errors path="vat" cssClass="error" />
					<form:input path="vat" name="vat" id="vat" placeholder="Vat"
						class="input100" />

					<form:errors path="vat" />
				</div>

				<div class="wrap-input100" data-validate="Please enter No of Parts">
					<%-- <form:label path="no_of_part">Number of Parts</form:label> --%>
					<form:input path="no_of_part" name="no_of_part" id="no_of_part"
						placeholder="No of Parts" class="input100"
					/>
				</div>
				<div class="wrap-input100">
					<%-- <form:label path="total_price">Total Price</form:label> --%>
					<form:input path="total_price" name="total_price" id="total_price"
						placeholder="Total Price" class="input200" readOnly="true"  />
				</div>
				<div class="wrap-input100">
					<%-- <form:label path="total_vat">Total Vat</form:label> --%>
					<form:input path="total_vat" name="total_vat" id="total_vat"
						placeholder="Total Vat" class="input200" readOnly="true"
						 />
				</div>
				<div class="wrap-input100 validate-readonly-input">
					<%-- <form:label path="total_amt">Total Amount</form:label> --%>
					<form:input path="total_amt" name="total_amt" id="total_amt"
						placeholder="Total Amount" class="input200"
						 />
				</div>
				<span class="contact100-form-message"> ${message} </span>
				<div class="container-contact100-form-btn">
					<button>
						<span> <form:button id="save" name="save"
								class="contact100-form-btn">Save</form:button>
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