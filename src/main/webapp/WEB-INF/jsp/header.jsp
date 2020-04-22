<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!doctype html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Header</title>
</head>
<body>
	<div class="container text-center">
		<h1>Ecommerce</h1>
		<p>Browse the products</p>
	</div>

	<nav class="navbar navbar-expand-lg bg-dark navbar-dark">


		<div class="d-flex flex-grow-1">
			<a class="navbar-brand" href="/home/">Home</a>

			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Products</a>
				</li>
			</ul>


		</div>

		<div class="collapse navbar-collapse flex-grow-1 text-right">
			<ul class="navbar-nav ml-auto flex-nowrap">
				<li class="nav-item"><a href="#" class="nav-link">Cart</a></li>
				<li class="nav-item"><a href="/login" class="nav-link">Logout</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>