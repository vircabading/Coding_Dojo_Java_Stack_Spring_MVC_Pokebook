<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- USE C:OUT -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- USE FORMAT DATE/ CURRENCY -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- USE FORM:FORM -->
<%@ page isErrorPage="true"%>
<!-- USE FLASH ERRORS -->

<!--/////////////////////////////////////////////////////
//	FORM FORM JSP
///////////////////////////////////////////////////////// -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- ---- CSS LINKS --------------------------------- -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Pokebook FORM:FORM</title>
</head>
<body>
	<!-- //// HEADER ///////////////////////////////////////////////// -->
	<header>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="/" class="navbar-brand d-flex align-items-center"> <strong
					class="text-warning">Pokebook</strong>
				</a> <a class="btn btn-secondary " href="/">HOME</a>
			</div>
		</div>
	</header>

	<!-- //// MAIN AREA /////////////////////////////////////////////// -->
	<main role="main">
		<div class="container mt-4">
			<h1>Expenses</h1>
			<br>
			<!-- //// ALL EXPENSES TABLE ////////////////////////////// -->
			<div class="row card bg-dark">
				<div class="col">
					<table class="table table-dark">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Expense</th>
								<th scope="col">Vendor</th>
								<th scope="col">Amount</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="expense" items="${ expenses }">
								<tr>
									<td>${ expense.id }</td>
									<td><a href="/expenses/${ expense.id }">${ expense.name }</a></td>
									<td>${ expense.vendor }</td>
									<td><fmt:formatNumber value="${expense.amount}"
											type="currency" /></td>
									<td class="row align-items-center">
										<!-- **** Button that points to Expense Edit ************ -->
										<form class="col m-2"
											action="/expenses/${ expense.id }/edit" method="get">
											<button class="btn btn-warning">Edit</button>
										</form> <!-- **** Button that deletes Expense ************ -->
										<form class="col m-2" action="/expenses/${ expense.id }/delete"
											method="post">
											<input type="hidden" name="_method" value="delete">
											<!-- ### Converts method of form to DELETE ### -->
											<button class="btn btn-danger">Delete</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<br>
			<div class="col bg-info p-3">
				<h1>Track an Expense:</h1>
				<!-- //// CREATE FORM ////////////////////////////////// -->
				<form:form action="/expenses" method="post" modelAttribute="expense">
					<p class="form-group">
						<form:label path="name">Expense name:</form:label>
						<form:input class="form-control mb-3" path="name" />
						<form:errors path="name" class="alert alert-danger" />
					</p>
					<p class="form-group">
						<form:label path="vendor">Vendor:</form:label>
						<form:input class="form-control mb-3" path="vendor" />
						<form:errors path="vendor" class="alert alert-danger" />
					</p>
					<p class="form-group">
						<form:label path="amount">Amount in $</form:label>
						<form:input class="form-control mb-3" type="number" path="amount"
							min="0.01" step="0.01" />
						<form:errors path="amount" class="alert alert-danger" />
					</p>
					<p class="form-group">
						<form:label path="description">Description</form:label>
						<form:textarea class="form-control mb-3" path="description" />
						<form:errors path="description" class="alert alert-danger" />
					</p>
					<input class="btn btn-success" type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</main>


	<!-- ---- JAVASCRIPT LINKS ---------------------------- -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>