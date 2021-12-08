<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--/////////////////////////////////////////////////////
//	EXPENSES JSP
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
<title>Pokebook</title>
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
		<div class="container mt-4">
			<h1>Expenses</h1>
			<br>
			<div class="row card bg-dark">
				<div class="col">
					<table class="table table-dark">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Expense</th>
								<th scope="col">Vendor</th>
								<th scope="col">Amount</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>${ name }</td>
								<td>${ vendor }</td>
								<td>${ amount }</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<br>
			<h1>
				Track an Expense:
			</h1>
			<form class="col" action="/expenses" method="post">
				<div class="form-group mb-2">
					<label class="form-label" for="name">Expense Name:</label>
					 <input class="form-control" type="text" id="name" name="name" 
				</div>
				<div class="form-group mb-2">
					<label class="form-label" for="vendor">Vendor:</label>
					 <input class="form-control" type="text" id="vendor" name="vendor">
				</div>
				<div class="form-group mb-2">
					<label class="form-label" for="amount">$ Amount:</label>
					 <input class="form-control" type="number" id="amount" name="amount">
				</div>
				<div class="form-group mb-2">
					<label for="description">Description:</label>
					<textarea class="form-control" id="description" name="description" rows="3"></textarea>
				</div>
				<input class="btn btn-primary" type="submit">
			</form>
		</div>
	</main>


	<!-- ---- JAVASCRIPT LINKS ---------------------------- -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>