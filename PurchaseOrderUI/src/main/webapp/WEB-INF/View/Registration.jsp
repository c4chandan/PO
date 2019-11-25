<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
table tr td {
	background-color: lightwheat;
	color: black;
	font-size: 20px;
}

.error {
	color: red;
		font-size: 20px;
}
</style>



<body>

	<f:errors path="*" />
	<div class="container table-responsive-md" style="width: 500px;">
		<div class="jumbotron" align="center">
			<h1>Registration</h1>
		</div>
		<f:form action="registerUser" method="post" modelAttribute="buyerObj">
			<table align="center"
				class="form-group table-responsive table table-hover">
				<tr>
				<tr>
					<td>Buyer Name</td>
					<td>:</td>
					<td><f:input path="buyer_Name" class="form-control" /></td>
					<td><f:errors path="buyer_Name" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Email</td>
					<td>:</td>
					<td><f:input path="email" class="form-control" /></td>
					<td><f:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td>:</td>
					<td><f:password path="password" class="form-control" /></td>
					<td><f:errors path="password" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Address</td>
					<td>:</td>
					<td><f:input path="address" class="form-control" /></td>
					<td><f:errors path="address" cssClass="error" /></td>

				</tr>
				<tr>
					<td>Mobile_no</td>
					<td>:</td>
					<td><f:input path="mobile_no" class="form-control" /></td>
					<td><f:errors path="mobile_no" cssClass="error" /></td>

				</tr>

				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="Submit" class="btn btn-success" /></td>
				</tr>
			</table>
		</f:form>
		${error}
	</div>

</body>
</html>