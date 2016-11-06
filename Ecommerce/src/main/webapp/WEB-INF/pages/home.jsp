<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Consulter produits</title>


<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>

<script src="<c:url value='/resources/js/npm.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>

</head>
<body>

	<h1 align="center">Bienvenue sur Ecommerce</h1>
	<table>
		<tr>
			<td>
				<div class="dropdown">
					<button class="btn btn-default btn-sm dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						Filtrer par catégorie <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">

						<li><a href="selectCategorie?IdCateg=0">Tous les produits</a></li>
						<c:forEach var="categ" items="${listeCateg}">
							<li><a href="selectCategorie?IdCateg=${categ.id_categorie}">${categ.nom}
							</a></li>
						</c:forEach>

					</ul>
				</div>
			</td>
			<td>
				<div>

					<form action="chercherProduit" method="post">
						<table>
							<tr>
								<td><a href="formInterrogFacture"
									class="btn btn-default btn-sm" type="button"> Facture</a></td>
									
								
								
								<td><a href="consulterPanier"
									class="btn btn-default btn-sm glyphicon glyphicon-shopping-cart"
									type="button"> Panier </a></td>
								<td><input type="text" name="motCle" class="form-control"></td>
								<td>
									<button type="submit" class="btn btn-default btn-lg">
										<span class="glyphicon glyphicon-search"></span>
									</button>
								</td>
							</tr>
						</table>
					</form>

				</div>
			</td>

		</tr>
	</table>


	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">Liste des produits ${accesFacture}</div>

		<!-- Table -->
		<table align="center" class="table">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Description</th>
					<th>Prix</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="produit" items="${listeProd}">
					<tr>
						<td>${produit.nom}</td>
						<td>${produit.description}</td>
						<td><fmt:formatNumber value="${produit.prix}" type="currency"
								currencySymbol="€" /></td>
						<td>
							<form action="consulterProduit?IdProduit=${produit.id_produit}"
								method="post">
								<input type="submit" value="Consulter">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>
	</div>

</body>
</html>