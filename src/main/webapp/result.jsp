<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>FLIGHTS</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<!-- Search Result begins -->

	<div class="container"></div>
	<div class="  mx-auto form p-4 font-weight-bold">
		<h1>
			<c:out value="${availableFlights.size()}"></c:out>
			matching flights found!
		</h1>
		<table class="table table-hover text-center">
			<thead class="thead-dark">
				<tr>
					<th>FLIGHT NUMBER</th>
					<th>DEPARTURE LOCATION</th>
					<th>ARRIVAL LOCATION</th>
					<th>FLIGHT VALID TILL</th>
					<th>FLIGHT TIME</th>
					<th>FLIGHT DURATION</th>
					<th>FARE</th>
					<th>SEAT AVAILABILITY</th>
					<th>CLASS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${availableFlights}" var="flight">
					<tr>
						<td>${flight.getFlightNumber()}</td>
						<td>${flight.getDepartLocation()}</td>
						<td>${flight.getArrivalLocation()}</td>
						<td>${flight.getFlightDate()}</td>
						<td>${flight.getFlightTime()}</td>
						<td>${flight.getFlightDuration()}hrs</td>
						<td>${flight.getFare()}</td>
						<td>${flight.getSeatAvailablility()}</td>
						<td>${flight.getFlightClass()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Search Result ends -->


</body>
</html>