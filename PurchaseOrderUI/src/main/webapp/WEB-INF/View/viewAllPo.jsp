<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Purchase Order</title>
</head>
<body>

<div>
<form method="get">
		<table class="table table-borderless table-hover">
				<thead>
					<tr>
						<!-- <th>PurchaseOrder Id</th> -->
						<th>PurchaseOrder Items</th>
						<th>PurchaseOrder Buyer_id</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productDetails}" var="obj">
						<tr>
							<%-- <td>${obj.purchaseOrderId}</td> --%>
							<td>${obj.purchaseOrderItemsObj}</td>
							<td>${obj.Buyer_id}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>
