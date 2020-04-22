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
<title>Admin Home</title>
</head>
<body>
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
								onClick="location.href='/products/${product.id} ' ">Browse</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br>
</body>
</html>