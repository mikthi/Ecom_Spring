<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>

<script src="<c:url value='/resources/js/npm.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>

</head>
<body>

	<h1 align="center">Votre panier</h1>



	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div align="center" class="panel-heading">produits commandés</div>

		<!-- Table -->
		<table align="center" class="table">
			<thead style="border-bottom: solid 2px black;">
				<tr>
					<th>Nom</th>
					<th>Prix</th>
					<th>Quantité</th>
					<th>Modifier panier</th>
				</tr>
			</thead>
			<tbody style="border-top: solid 2px;">
				<c:forEach var="listeProduitPanier" items="${listePanier}">
					<tr>
						<td>${listeProduitPanier.nom}</td>
						<td><fmt:formatNumber value="${listeProduitPanier.prix}"
								type="currency" currencySymbol="€" /></td>
						<td>${panier.produitCommande[listeProduitPanier.id_produit]}</td>
						<td>
							<form action="supprimerProduitPanier?IdProduitASup=${listeProduitPanier.id_produit}"
								method="post">
								<input type="submit" value="Retirer produit du panier">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot style="border-top: solid 2px;">

				<tr>
					<td>Le montant de votre transaction s'élève à</td>
					<td><strong><fmt:formatNumber
								value="${panier.montantTotalPanier}" type="currency"
								currencySymbol="€" /></strong></td>
					<td><a href="passerCommande" class="btn btn-default btn-sm" type="button">
							Commander </a></td>
								<td>	<a  href="accueil" class="btn btn-default btn-sm"
						type="button"> retour à l'accueil </a></td>
				</tr>
			</tfoot>

		</table>
	</div>
</body>
</html>