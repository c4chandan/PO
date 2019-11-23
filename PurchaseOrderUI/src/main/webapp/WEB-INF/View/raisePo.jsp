<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	
<script>
    $(document).ready(function(){
        $(".add-row").click(function(){
            var items = $(".name option:selected").val();
            var quantity = $("#quantity").val();
            var markup = "<tr><td><input type='checkbox' name='record'></td><td>" + items + "</td><td>" + quantity + "</td></tr>";
            $("table ").append(markup);
        });
        
        // Find and remove selected table rows
        $(".delete-row").click(function(){
            $("table tbody").find('input[name="record"]').each(function(){
                if($(this).is(":checked")){
                    $(this).parents("tr").remove();
                }
            });
        });
    });    
</script>


</head>
<body>

	<div class="container">
	
<h1 style="color: green;">Raise Po</h1>
 		<form action="purchaseOrder" method="post">
 	<select class="form-control name" name="items">
						<option value="">Select your products</option>
						<c:forEach items="${productDetails}" var="pObj">
						<option value="${pObj.productName} "> 
						${pObj.productName} 
						</option>
						</c:forEach>
						</select>
						<input type="number" min="0" pattern="\d*"  class="form-control" placeholder="Quantity" id="quantity" required/>
						<input type="button" value="Add"	class="btn btn-success add-row" />



		    <table class="table-responsive table-dark table table-hover">
        <thead>
            <tr>
                <th>Select</th>
                <th>items</th>
                <th>quantity</th>
            </tr>
        </thead>
        <tbody>
        <tr>
        </tr>
        </tbody>
  </table>
			<div class="row">
			<div class="col">	<button type="button" class="delete-row">Delete Row</button>
			</div>		
	<div class="col"><input type="submit" value="submit"	class="btn btn-primary" /></div>
		</div>

	
	</form>
	</div>
	</body>
</html>