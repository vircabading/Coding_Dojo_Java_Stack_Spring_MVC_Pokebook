<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		<!-- USE C:OUT -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	<!-- USE FORMAT DATE/ CURRENCY -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	<!-- USE FORM:FORM -->
<%@ page isErrorPage="true" %>										<!-- USE FLASH ERRORS -->

<!--/////////////////////////////////////////////////////
//	EXPENSES ID EDIT JSP
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
			<div class="col bg-info p-3">
				<h1>EDIT an Expense:</h1>
				<!-- //// EDIT FORM /////////////////////////////////// -->
				<h2 class="alert alert-warning">${ message }</h2>
				<form:form action="/expenses/${ expense.id }/edit" method="post" modelAttribute="expense">
					<input type="hidden" name="_method" value="put">	<!-- ### Converts method of form to PUT ### -->
					<p class="form-group">							<!-- **** NAME **** -->
						<form:label path="name">Expense name:</form:label>
						<form:input class="form-control mb-3" path="name" />
						<form:errors path="name" class="alert alert-danger" />
					</p>
					<p class="form-group">							<!-- **** VENDOR **** -->
						<form:label path="vendor">Vendor:</form:label>
						<form:input class="form-control mb-3" path="vendor" />
						<form:errors path="vendor" class="alert alert-danger" />
					</p>
					<p class="form-group">							<!-- **** AMOUNT **** -->
						<form:label path="amount">Amount in $</form:label>
						<form:input class="form-control mb-3" type="number" path="amount"
							min="0.01" step="0.01" />
						<form:errors path="amount" class="alert alert-danger" />
					</p>
					<p class="form-group">							<!-- **** DESCRIPTION **** -->
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