<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulter produits</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"/>
    <script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>
    
    <script src="<c:url value='/resources/js/bootstrap.js' />"></script>
 <script src="<c:url value='/resources/js/npm.js' />"></script>
</head>
<body>

	<h1 align="center">Bienvenue sur Ecommerce</h1>

	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button"
			id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="true">
			Liste des catégories <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
			<li><a href="#">Action</a></li>
			<li><a href="#">Another action</a></li>
			<li><a href="#">Something else here</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Separated link</a></li>
		</ul>
	</div>

	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">Liste des produits</div>

		<!-- Table -->
		<table align="center" class="table">

			<tr>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
			</tr>

			<tr>
				<td>Un produit</td>
				<td>mon produit</td>
				<td>10.99</td>


			</tr>
		</table>
	</div>

</body>
</html>