<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits</title>
</head>
<body>
	<%@include file="template/header.jsp"%>

	<div class="container" align="center">
		<h2 style="font-family: cursive; font-style: italic;">Affichage
			des produits</h2>
		<br />
		<table class="table table-hover">
			<tr bgcolor="grey" style="color: white" align="center">
				<td style="font-weight: bold;">ID</td>
				<td style="font-weight: bold;">Catégorie</td>
				<td style="font-weight: bold;">Nom</td>
				<td style="font-weight: bold;">Description</td>
				<td style="font-weight: bold;">Prix</td>
				<td class="col-md-1" colspan="2" style="font-weight: bold;">Edition</td>
			</tr>
			<c:forEach var="prod" items="${listeProd}">
				<tr align="center">
					<td style="vertical-align: center;">${prod.id_produit}</td>
					<td>${prod.categorie.nom}</td>
					<td>${prod.nom}</td>
					<td>${prod.description}</td>
					<td>${prod.prix}&euro;</td>
					<td>
						<form action="formModifProd?IdProduit=${prod.id_produit}"
							method="post">
							<button type="submit" class="btn btn-warning btn-lg">Modifier</button>
						</form>
					</td>
					<td>
						<form action="supprimerProduit?IdProduit=${prod.id_produit}"
							method="post">
							<button type="submit" class="btn btn-warning btn-lg">Supprimer</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

		<br />
		<a style="float: right;"
			href="<c:url value="/j_spring_security_logout" />"> Se
			deconnecter</a>

	</div>
</body>
</html>