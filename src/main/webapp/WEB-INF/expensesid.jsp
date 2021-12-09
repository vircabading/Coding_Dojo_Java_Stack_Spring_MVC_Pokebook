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
//	EXPENSE ID JSP
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
	<!-- //// HEADER //////// -->
	<header>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="/" class="navbar-brand d-flex align-items-center"> <strong
					class="text-warning">Pokebook</strong>
				</a> <a class="btn btn-secondary " href="/">HOME</a>
			</div>
		</div>
	</header>

	<!-- //// MAIN AREA //////// -->
	<main role="main">
		<div class="container mt-4 bg-info rounded p-2">
			<h1>Expense Details:</h1>
			<div class="row mb-3">
				<div class="col-3">
					<strong> Expense name: </strong>
				</div>
				<div class="col-8">${ expense.name }</div>
			</div>
			<div class="row mb-3">
				<div class="col-3">
					<strong> Vendor: </strong>
				</div>
				<div class="col-8">${ expense.vendor }</div>
			</div>
			<div class="row mb-3">
				<div class="col-3">
					<strong> Amount </strong>
				</div>
				<div class="col-8">
					<fmt:formatNumber value="${expense.amount}" type="currency" />
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-3">
					<strong> Description: </strong>
				</div>
				<div class="col-8">${ expense.description }</div>
			</div>
			<div class="row">
				<!-- **** Button that points to Expense Edit ************ -->
				<form class="col-1 me-2"action="/expenses/${ expense.id }/edit" method="get">
					<button class="btn btn-warning">Edit</button>
				</form>

				<!-- **** Button that deletes Expense ************ -->
				<form class="col-1" action="/expenses/${ expense.id }/delete" method="post">
					<input type="hidden" name="_method" value="delete">
					<!-- ### Converts method of form to DELETE ### -->
					<button class="btn btn-danger">Delete</button>
				</form>
			</div>
		</div>
	</main>


	<!-- ---- JAVASCRIPT LINKS ---------------------------- -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>