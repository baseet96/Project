<%@ include file="shopperHeader.jsp"%>
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

	<div class="row h-100 justify-content-center align-items-center">
		<div class="card border-light mb-3" style="max-width: 18rem;">
			<div class="card-header">
				<u>${product.name}</u>
			</div>
			<div class="card-body">
				<h5 class="card-title">${product.description}</h5>
				<p class="card-text">Discount: ${product.discount}%</p>
				<p class="card-text">Delivery: $${product.deliveryCharge}</p>
				<p class="card-text">Inventory: ${product.inventory}</p>
			</div>
			<div class="card-footer bg-transparent text-center">$${product.price}
			</div>
			<div class="card-footer bg-transparent text-center">
				<button type="button" class="btn btn-primary btn-md"
					onClick="location.href=' ' ">Add</button>
			</div>
		</div>
	</div>

</body>
</html>