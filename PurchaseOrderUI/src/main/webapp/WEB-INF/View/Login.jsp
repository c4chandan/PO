<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

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
<style>


.error {
	color: red;
	FONT-FAMILY: Lucida Handwriting;
	font-size: 10px;
}
</style>


</head>
<body>

<f:errors path="*"/>
<f:form action="Loginform" method="post" modelAttribute="login">
<table>
<tr> 
<td> User Email</td>
<td>:</td>
<td><td><f:input path="Email" class="form-control" /></td></td>
<td><f:errors path="Email" cssClass="error" /></td>
</tr>
<tr> 
<td>Password</td>
<td>:</td>
<td><f:password path="password" class="form-control"/></td>
<td><f:errors path="Password" cssClass="error" /></td>
</tr>
<tr>
<td></td>
<td></td>
<td><input type="submit" name="submit" value="submit"/></td>
</tr>
</table>
</f:form>
  <h3 style="color:red;font-size:15px">${msg}</h3>
</body>
</html>