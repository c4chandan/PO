<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	border: 1px solid black;
}
</style>

<body id="box">
	<div class="container">
		<h1 style="color: green;">Product List</h1>
		<table class="table table-borderless  table table-hover table-dark">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Available Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pObjDetails}" var="obj">
					<tr>
						<td>${obj.product_Obj.productName}</td>
						<td>${obj.quantity}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>