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
<title>Shopper Home</title>
</head>
<body>


<div class="row h-100 justify-content-center align-items-center">
<c:forEach items="${products}" var="product">
		<div class="card border-light mb-3" style="max-width: 18rem;">
			<div class="card-header">
				<u>${product.getName()}</u>
			</div>
			<div class="card-body">
				<h5 class="card-title">${product.description}</h5>
			</div>
			<div class="card-footer bg-transparent text-center">$${product.price}
			</div>
			<div class="card-footer bg-transparent text-center">
				<button type="button" class="btn btn-primary btn-md"
					onClick="location.href='/shopper/${product.id}' ">Add</button>
			</div>
		</div>
		</c:forEach>
	</div>



	<div class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">${product.name}</div>
						<div class="panel-body">
							<p>Price : ${product.price}</p>
						</div>
						<div class="panel-footer">
							<button type="button" class="btn btn-primary btn-md"
								onClick="location.href='/shopper/${product.id} ' ">Browse</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br>
</body>
</html>