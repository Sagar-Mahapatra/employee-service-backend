<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />

<style>
.row {
	padding-bottom: 5px;
}

label, b {
	text-transform: uppercase;
}
</style>
</head>

<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h3>EMPLOYEE UPDATE PAGE</h3>
			</div>
			<div class="text-center text-success">
				<h3>${message}</h3>
			</div>
			<!-- card header end -->
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="employee"
					id="regForm">

					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-5">
							<form:input path="id" class="form-control" hidden="hidden" />
						</div>

					</div>
					<!-- row#1 -->
					<div class="row">
						<div class="col-md-3">
							<label for="empName">NAME</label>
							<!-- for attribute is used to link form input focus -->
						</div>
						<div class="col-md-5">
							<form:input path="empName" class="form-control" />
						</div>

					</div>

					<!-- row#3 -->
					<div class="row">
						<div class="col-md-3">
							<label for="empDept">DEPARTMENT</label>
							<!-- for attribute is used to link form input focus -->
						</div>
						<div class="col-md-5">
							<select name="empDept" class="form-control">
								<option value="DEV">DEV</option>
								<option value="QA">QA</option>
								<option value="DEVOPS">DEVOPS</option>
								<option value="MANAGER">MANAGER</option>
								<option value="HR">HR</option>
							</select>
						</div>

					</div>

					<!-- row#3 -->
					<div class="row">
						<div class="col-md-3">
							<label for="empEmail">EMAIL</label>
							<!-- for attribute is used to link form input focus -->
						</div>
						<div class="col-md-5">
							<form:input path="empEmail" type="email" class="form-control" />
						</div>

					</div>

					<!-- row#4 -->
					<div class="row">
						<div class="col-md-3">
							<label for="empContact">CONTACT</label>
							<!-- for attribute is used to link form input focus -->
						</div>
						<div class="col-md-5">
							<form:input path="empContact" class="form-control" />
						</div>

					</div>


					<!-- row#6 -->
					<div class="row">
						<div class="col-md-3">
							<label for="empGender">GENDER</label>
						</div>
						<div class="col-md-5">
							<form:radiobutton path="empGender" value="Male" />
							Male
							<form:radiobutton path="empGender" value="Female" />
							Female
						</div>
					</div>
					<!-- row#3 -->
					<div class="row">
						<div class="col-md-3">
							<label for="empSalary">SALARY</label>
							<!-- for attribute is used to link form input focus -->
						</div>
						<div class="col-md-5">
							<form:input path="empSalary" class="form-control" />
						</div>

					</div>
					<!-- row#3 -->
					<div class="row">
						<div class="col-3">
							<label>PRESENT ADDRESS</label>
						</div>
						<div class="col-5">

							<div class="row">
								<div class="col-5">
									<label>City</label>
								</div>
								<div class="col-7">
									<form:input path="empAddr[0].city" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-5">
									<label>State</label>
								</div>
								<div class="col-7">
									<form:input path="empAddr[0].state" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-5">
									<label>Country</label>
								</div>
								<div class="col-7">
									<form:input path="empAddr[0].country" class="form-control" />
								</div>
							</div>
						</div>
					</div>
					<br />
					<!-- row#3 -->
					<div class="row">
						<div class="col-3">
							<label>PERMANENT ADDRESS</label>
						</div>
						<div class="col-5">

							<div class="row">
								<div class="col-5">
									<label>City</label>
								</div>
								<div class="col-7">
									<form:input path="empAddr[1].city" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-5">
									<label>State</label>
								</div>
								<div class="col-7">
									<form:input path="empAddr[1].state" class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col-5">
									<label>Country</label>
								</div>
								<div class="col-7">
									<form:input path="empAddr[1].country" class="form-control" />
								</div>
							</div>
						</div>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-success">Update</button>
						<button type="reset" class="btn btn-danger">Clear</button>
					</div>
				</form:form>
			</div>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>