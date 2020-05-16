<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List Invoice</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main1.css">
</head>
<body>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">

					<form:form method="post" action="getInvoice"
						modelAttribute="InvoiceForm">
						<div class="table100-head">
							<table>
								<thead>
									<tr>
										<th class="cell100 column1">Invoice id</th>
										<th class="cell100 column2">Purchase Price</th>
										<th class="cell100 column3">Vat</th>
										<th class="cell100 column4">No of Parts</th>
										<th class="cell100 column5">Total price</th>

										<th class="cell100 column6">Total vat</th>
										<th class="cell100 column7">Total amount</th>
										<th class="cell100 column8">Edit/Delete</th>
										<th class="cell100 column9">PDF</th>
									</tr>
								</thead>
							</table>
						</div>
						<div class="table100-body js-pscroll">
							<table>
								<tbody>

									<c:forEach items="${invoiceList}" var="invoice">
										<tr class="row100 body">
											<%-- 	<td align="center">${status.count}</td> --%>
											<td class="cell100 column1">${invoice.invoice_id}</td>
											<td class="cell100 column2">£${invoice.p_price}</td>
											<td class="cell100 column3">£${invoice.vat}</td>
											<td class="cell100 column4">${invoice.no_of_part}</td>
											<td class="cell100 column5">£${invoice.total_price}</td>
											<td class="cell100 column6">£${invoice.total_vat}</td>
											<td class="cell100 column7">£${invoice.total_amt}</td>
											<td class="cell100 column8"><a href="Edit/${invoice.invoice_id}"/a href="Delete/${invoice.invoice_id}">Edit/Delete</a></td>
											
											<td class="cell100 column9"><a href="generatepdf/${invoice.invoice_id}">PDF</a></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>