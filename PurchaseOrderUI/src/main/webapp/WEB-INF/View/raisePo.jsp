<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="row">
 
  <div class="col-sm-6">
 Iteams
  <!--        <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
     
    </ul>
  </div>
 -->
 <c:forEach items="${purchaseObj}" var="i">
      <c:out value = "${i.name}"/><p>
      </c:forEach>
</div>
  <div class="col-sm-6">
  Quantity 
  <input type="number" min="0" pattern="\d*"/>
  
  </div>
</div>

<br/>

 <table class="table table-dark">
    <thead>
      <tr>
        <th> Iteams</th>
        <th> Quantity</th>
       </tr>
    </thead>
    <tbody>
      
       <tr>
       <td></td>
       <td></td>
       <td><input type="submit" value="submit" class="btn btn-primary" /></td>

       </tr>
     </tbody>
  </table>
  
  </div>
</body>
</html>