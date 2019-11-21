<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="container"> 
	<f:form action="registerUser" method="post" modelAttribute="buyerObj">
		<table align="center" class="form-group table-responsive table table-hover">
			<tr>
				<td  scope="col">Buyer Id</td>
				<td  scope="col">:</td>
				<td  scope="col"><f:input path="buyer_Id" class="form-control" /></td>
				
			</tr>

			<tr>
				<td>Buyer Name</td>
				<td>:</td>
				<td><f:input path="buyer_Name" class="form-control" /></td>
		
			</tr>

			<tr>
				<td>Email</td>
				<td>:</td>
				<td><f:input path="Email"  class="form-control"/></td>
				
			</tr>
		<tr>
				<td>Password :</td>
				<td>:</td>
				<td><f:password path="Password" class="form-control" /></td>
				<td></td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td>:</td>
				<td><f:input path="Address"  class="form-control"/></td>
				
			</tr>
				<tr>
				<td>Mobile_no</td>
				<td>:</td>
				<td><f:input path="Mobile_no" class="form-control" /></td>
				
			</tr>
		
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="Submit" class="btn btn-info" /></td>
			</tr>
		</table>
	</f:form>
</div>

</body>
</html>