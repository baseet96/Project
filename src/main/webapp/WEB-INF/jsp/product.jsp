<%@ include file="header.jsp"%>
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
<title>Product</title>
</head>
<body>


	<div class="card border-light mb-3" style="max-width: 18rem;">
		<div class="card-header">Header</div>
		<div class="card-body">
			<h5 class="card-title">Light card title</h5>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
		</div>
		<div class="card-footer bg-transparent border-success">Footer</div>
	</div>
	<div class="container">
		<div class="row">

			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">${product.name}</div>
					<div class="panel-body">
						<p>Description : ${product.description}</p>
						<p>Price : ${product.price}</p>
					</div>
					<div class="panel-footer">
						<button type="button" class="btn btn-primary btn-md"
							onClick="location.href=' ' ">Buy</button>
					</div>
				</div>
			</div>

		</div>
	</div>
	<br>
</body>
</html>