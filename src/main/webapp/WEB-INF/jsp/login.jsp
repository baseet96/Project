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
<title>Login</title>
</head>
<body>

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						<h4 class="card-title mt-2">Login</h4>
					</header>
					<article class="card-body">
						<form>

							<div class="form-group">
								<label>Email address</label> <input type="email"
									class="form-control" placeholder="">
							</div>
							<!-- form-group end.// -->

							<div class="form-group">
								<label>Password</label> <input class="form-control"
									type="password">
							</div>
							<!-- form-group end.// -->
							<div class="form-group">
								<a href="/home" class="btn btn-dark btn-block" role="button">Login</a>
							</div>
							<!-- form-group// -->
						</form>
					</article>
					<div class="border-top card-body text-center">
						Don't have an account? <a href="/registration">Register</a>
					</div>
				</div>
			</div>

		</div>

</body>
</html>