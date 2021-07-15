<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>

<title>Home- Flight Search</title>
</head>
<body>

	<c:if test="${userName == null}">
		<c:redirect url="index.jsp" />
	</c:if>

	<!-- Navbar -->

	<jsp:include page="header.jsp" />

	<!-- Navbar ends -->

	<!-- Flight Search form begins -->
	<div
		class="col-xl-8 col-lg-6 col-md-8 col-sm-10  mx-auto form p-4 font-weight-bold">
		<h1 class="display-4 py-2">Search Flights</h1>
		<div class="px-2">
			<form action="Search" class="justify-content-center">
				<div class="form-group row">
					<label for="example-date-input" class="col-2 col-form-label">From
						:</label>
					<div class="col-10">
						<select class="custom-select" name="from">
							<c:forEach items="${fromAirportStateCodes}"
								var="fromAirportStateCode">
								<option value="${fromAirportStateCode}">${fromAirportStateCode}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label for="example-date-input" class="col-2 col-form-label">To
						:</label>
					<div class="col-10">
						<select class="custom-select" name="to">
							<c:forEach items="${toAirportStateCodes}"
								var="toAirportStateCode">
								<option value="${toAirportStateCode}">${toAirportStateCode}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label for="example-date-input" class="col-2 col-form-label">Date
						:</label>
					<div class="col-10">
						<input class="form-control" type="date" name="date" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="example-date-input" class="col-2 col-form-label">Class
						:</label>
					<div class="col-10">
						<select class="custom-select" name="class">
							<option value="E">Economy</option>
							<option value="B">Business</option>
						</select>
					</div>
				</div>

				<div class="form-group row">
					<label for="example-date-input" class="col-2 col-form-label">Sort
						By :</label>
					<div class="col-10">
						<select class="custom-select" name="sortBy">
							<option value="1">Fare</option>
							<option value="2">Flight Duration</option>
						</select>
					</div>
				</div>
	
				<button style="float: right" type="submit"
					class="btn btn-primary btn-lg">Search</button>
			</form>
			
		</div>
	</div>

	<!-- Flight Search form ends -->
	
	

</body>
</html>