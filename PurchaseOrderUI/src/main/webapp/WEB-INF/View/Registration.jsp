<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring</title>
<style>
.error {
	color: red;
	FONT-FAMILY: Lucida Handwriting;
	font-size: 10px;
}

body {
	margin-left: 50px;
	padding: 10px 20px;
	font-size: 20px;
}

table {
	width: 500px;
	height: 250px;
	margin: 5px;
	paddding: 10px 20px;
	font-size: 20px;
}

table tr td input {
	border-radius: 3px;
	width: 250px;
	height: 25px;
}

table tr td input:hover {
	background-color: lightyellow;
}
</style>

</head>
<body>
	<h2 align="center"
		style="color: red; font-size: 20px; padding: 10px 20px;">${formLabel}</h2>
	<f:form action="registerUser" method="post" modelAttribute="buyerObj">
		<table align="center">
			<tr>
				<td>Buyer Id</td>
				<td>:</td>
				<td><f:input path="buyer_Id" /></td>
				<td></td>
			</tr>

			<tr>
				<td>Buyer Name</td>
				<td>:</td>
				<td><f:input path="buyer_Name" /></td>
				<td></td>
			</tr>

			<tr>
				<td>Email</td>
				<td>:</td>
				<td><f:input path="Email" /></td>
				<td></td>
			</tr>
		<tr>
				<td>Password :</td>
				<td>:</td>
				<td><f:password path="Password" /></td>
				<td></td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td>:</td>
				<td><f:input path="Address" /></td>
				<td></td>
			</tr>
				<tr>
				<td>Mobile_no</td>
				<td>:</td>
				<td><f:input path="Mobile_no" /></td>
				<td></td>
			</tr>
		
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</f:form>


</body>
</html>