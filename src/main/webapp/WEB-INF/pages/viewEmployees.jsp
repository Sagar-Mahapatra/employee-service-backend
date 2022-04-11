<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />

<title>ALL EMPLOYEES LIST</title>
</head>
<body>
	<div class="text-center">
		<h1 class="text-info">ALL EMPLOYEES LIST</h1>
		<h2 class="text-success">${message}</h2>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Department</th>
				<th scope="col">Contact</th>
				<th scope="col">Salary</th>
				<th scope="col">Gender</th>
				<th scope="col">Present Address</th>
				<th scope="col">Permanent Address</th>

				<th scope="col" colspan="2">Operations</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach var="employee" items="${employees}">

				<tr>
					<td>${employee.id}</td>
					<td>${employee.empName}</td>
					<td>${employee.empEmail}</td>
					<td>${employee.empDept}</td>
					<td>${employee.empContact}</td>
					<td>${employee.empSalary}</td>
					<td>${employee.empGender}</td>
					<td>${employee.empAddr[0].city},${employee.empAddr[0].state},${employee.empAddr[0].country}</td>
					<td>${employee.empAddr[1].city},${employee.empAddr[1].state},${employee.empAddr[1].country}</td>

					<td><a href="edit?id=${employee.id}" class="btn btn-primary">Edit</a></td>
					<td><a href="delete?id=${employee.id}" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>