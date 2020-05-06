<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Invoice List</title>
</head>
<body>
<form:form method="post" action="getInvoice" modelAttribute="InvoiceForm">
<h2>Invoice List</h2>
	<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Invoice id</th>
		<th>Purchase Price</th>
		<th>Vat</th>
		<th>No of Parts</th>
		<th>Total price</th>
		
		<th>Total vat</th>
		<th>Total amount</th>
		<th>PDF</th>
	</tr>
	<c:forEach items="${invoiceList}" var="invoice" >
		<tr>
		<%-- 	<td align="center">${status.count}</td> --%>
			<td><input value="${invoice.invoice_id}"/></td>
			<td><input value="${invoice.p_price}"/></td>
			<td><input value="${invoice.vat}"/></td>
			<td><input value="${invoice.no_of_part}"/></td>
			<td><input value="${invoice.total_price}"/></td>
			<td><input value="${invoice.total_vat}"/></td>
			<td><input value="${invoice.total_amt}"/></td>
			   <td><a href="generatepdf/${invoice.invoice_id}">PDF</a></td>  
			
		</tr>
	</c:forEach>
</table>	
<br/>

	
</form:form>
</body>
</html>