<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Purchase Order</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<style>
#box {
	width: 1100px;
	margin-left: 120px;
	padding: 5px;
	
}
</style>
<SCRIPT type="text/javascript">
		console.log('I m here');
    	window.history.forward();
    	function noBack() {
    		window.history.forward();
    		
    	}
	</SCRIPT>
<body id="box" onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="noBack()">
<nav
		class="navbar navbar-expand-md bg-dark navbar-dark navbar-fixed-top">
	<!-- Brand --> <a class="navbar-brand" href="#">Purchase Order</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- Navbar links -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="viewAllpurchaseOrder">View All purchase Order</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
			<li class="nav-item"><a class="nav-link" href="logout">LogOut</a>
			</li>
		</ul>
	</div>
	</nav>
<br/>
<div class="container">
<form method="get">
		<table class="table table-borderless table-hover">
				<thead>
					<tr>
						<!-- <th>PurchaseOrder Id</th> -->
						<th>PurchaseOrder Id</th>
						<th>Buyer id</th>
						<th>Seller Id</th>
					<th> Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pOlist}" var="pO">
						<tr>
							<td>${pO.purchaseOrderId}</td> 
							<td>${pO.buyerObj.buyer_Id}</td>
							<td>${pO.sellerObj.buyer_Id}</td>
							<td>${pO.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>
