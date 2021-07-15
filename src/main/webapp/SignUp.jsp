<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>Login</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poiret+One&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<style>
body {
	font-family: 'Poiret One', cursive;
	font-weight: bold;
}
</style>
<title>SignUp- Flight Search</title>
</head>
<body>

	<!-- Sign Up form begin -->
	<div class="col-xl-8 col-lg-6 col-md-8 col-sm-10  mx-auto form p-4">
		<h1 class="display-4 py-2">Sign Up</h1>
		<div class="px-2">
			<form method="post" action="SignUp" class="justify-content-center">
				<div class="form-group">
					<small id="help" class="form-text text-danger">Your
						information is safe with us.</small>
				</div>
				<div class="form-group">

					<input type="text" class="form-control" placeholder="USERNAME"
						name="userName" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="PASSWORD"
						name="password" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control"
						placeholder="CONFIRM PASSWORD" name="confirmPassword" required>
				</div>
				<button style="float: right" type="submit"
					class="btn btn-primary btn-lg">Sign Up</button>
			</form>
		</div>
		
		<div class="container-fluid text-danger">

		<c:if test="${signupmessage != null }">

			<c:out value="${signupmessage}"></c:out>

		</c:if>
	</div>
	
	</div>
	<!-- Sign Up form ends -->
	
	

</body>
</html>