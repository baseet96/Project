<%@ include file="adminHeader.jsp"%>
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
<title>Add Product</title>
</head>

<body>

	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card">
				<header class="card-header">
					<h4 class="card-title mt-2">Add Product</h4>
				</header>
				<article class="card-body">
					<form>
						<div class="form-group">
							<label>Name</label> <input type="email" class="form-control"
								placeholder="">
						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<label>Description</label> <input type="description"
								class="form-control" placeholder="">
						</div>
						<div class="form-group">
							<label>Price</label> <input type="price"
								class="form-control" placeholder="">
						</div>
						<div class="form-group">
							<label>Discount</label> <input type="discount"
								class="form-control" placeholder="">
						</div>
						<div class="form-group">
							<label>Delivery Charge</label> <input type="delivery"
								class="form-control" placeholder="">
						</div>
						<div class="form-group">
							<label>Inventory</label> <input type="inventory"
								class="form-control" placeholder="">
						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<a href="" class="btn btn-dark btn-block">Add</a>
						</div>
						<!-- form-group// -->
					</form>
				</article>
			</div>
		</div>
	</div>

</body>
</html>