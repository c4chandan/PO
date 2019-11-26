<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="images"
	value="${pageContext.request.contextPath}/resources/images"
	scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>

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
table {
	width: 100%;
	margin: 20px 0;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #cdcdcd;
}

table th, table td {
	padding: 5px;
	text-align: left;
}

#box {
	width: 1100px;
	margin-left: 120px;
	padding: 5px;
	
}
</style>
<script>
     var allImages = ["1.jpg", "2.jpg", "4.jpg","5.jpg"];
            var imgno = 0;
            function moveSlide() {
                var im = document.getElementById("imgslide");
                im.src = "${images}/" + allImages[imgno];
                imgno++;
                if (imgno == allImages.length)
                    imgno = 0;
                window.setTimeout("moveSlide()", 5000);
     }
     </script>
</head>
<body onload="moveSlide()" id="box" >




	<nav
		class="navbar navbar-expand-md bg-dark navbar-dark navbar-fixed-top">
	<!-- Brand --> <a class="navbar-brand" href="#">Purchase Order</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- Navbar links -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="getSignUpPage">Registration</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="getLoginForm">Login</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
		</ul>
	</div>
	</nav>

	<br />
	<div style="background-color: #4d4d4d;">

		<img id="imgslide" width="100%" height="200px" />

	</div>


	<h1 style="text-align: center; font-family: verdana; color: green">
		${msg}</h1>

	<hr />





</body>
</html>