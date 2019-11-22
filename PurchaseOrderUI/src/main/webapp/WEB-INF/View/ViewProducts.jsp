<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
	<head>
		<title>Spring Web MVC</title>
		<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1>View Products</h1>
		<div >
<h4>Iteams</h4>
 <h4> Quantity </h4>
 </div>
		<table>
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				
				<th>Product Price</th>
			</tr>
			<c:forEach items="${productDetails}" var="pObj">
			<tr>
				<td>${pObj.productId}</td>
				<td>${pObj.productName}</td>
				
				<td>${pObj.productPrice}</td>
			</tr>
			</c:forEach>
		</table>
		
		
		 <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
    <c:forEach items="${productDetails}" var="pObj">
     <li><a href="#">${pObj.productName}</a> </li>
     </c:forEach>
    </ul>
  </div>
	</body>
</html>