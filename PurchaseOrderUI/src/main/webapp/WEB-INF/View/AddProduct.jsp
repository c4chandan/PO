<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>products</title>
</head>
<body>
<h1>Add Product</h1>
		<f:form action="addProduct" method="post" modelAttribute="productObj" id="proForm">
			<table>
				<tr>
					<td>Product Name : </td>
					<td>
						<f:input path="productName" id="pName" />
						<div id="msg" style="color:red;font-style:italic;"></div>
					</td>
				</tr>
		
				<tr>
					<td>Product Price : </td>
					<td>
						<f:input path="productPrice" id="price"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Add Product" id="addPro">
					</td>
				</tr>
			</table>
		</f:form>
		

</body>
</html>