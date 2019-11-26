<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Quantity</title>
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
        padding:5px;
      
 }
</style>

<body id="box">
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Purchase Order</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="getAllAvailableProductsByVendor">Available Products</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="getAllProducts">View All products</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="updateQuantity">Change In Quantity</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About Us</a>
      </li>
        <li class="nav-item"><a class="nav-link" href="logout">LogOut</a>
				</li>
    </ul>
  </div>
</nav>
<div class="container">
<h1 style="color: green;">Add Quantity</h1>
		<form action="updateQuantity" method="post">
		<table class="table table-borderless table-hover">
			<thead>
				<tr>
					<th>select the Items</th>
					<th>select the Quantity</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<select class="form-control" name="pId">
						<option value="0">Select your products</option>
						<c:forEach items="${pObjDetails}" var="pObj">
						<option value="${pObj.productId}"> 
						${pObj.productName} 
						</option>
						</c:forEach>
						</select>
						</td>
					<td><input  type="number" min="0" pattern="\d*"  class="form-control" placeholder="Quantity" name="quantity" required/></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="Add"	class="btn btn-primary" /></td>
				</tr>
			</tbody>
		</table>
		</form>
<c:if test="${not empty msg}"> 
<span class="alert alert-success">${msg}</span><br/>
</c:if>
</div>

</body>
</html>