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
	<div align="center">

		<table>
			<tr>
				<td>
					<form action="formAjoutCateg">
						<input type="submit" value="Ajouter Catégorie">
					</form>
				</td>
				<td>
					<form action="formAjoutProd">
						<input type="submit" value="Ajouter Produit">
					</form>
				</td>
				<td>
					<form action="chercherProduit" method="post">
						<input type="text" name="motCle"> 
						<input type="submit" value="Chercher">
					</form>
				</td>
				<td align="right">
					<form action="listeCategories">
						<input type="submit" value="Afficher Catégories">
					</form>
				</td>
				<td>
					<form action="listeProduits">
						<input type="submit" value="Afficher Produits">
					</form>
				</td>
			</tr>
		</table>
		
		<h1>Affichage des produits</h1>

		<table>
			<tr bgcolor="grey" style="color: white">
				<th>ID</th>
				<th>Catégorie</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Edition</th>
			</tr>
			<c:forEach var="prod" items="${listeProd}">
				<tr>
					<td>${prod.id_produit}</td>
					<td>${prod.categorie.nom}</td>
					<td>${prod.nom}</td>
					<td>${prod.description}</td>
					<td>${prod.prix}</td>
					<td>
						<form style="float: left;"
							action="formModifProd?IdProduit=${prod.id_produit}" method="post">
							<input type="submit" value="Modifier">
						</form>
						<form style="float: right;"
							action="supprimerProduit?IdProduit=${prod.id_produit}"
							method="post">
							<input type="submit" value="Supprimer">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

		<br/>
		<br/> 
		<br/>
		<a href="<c:url value="/j_spring_security_logout" />"> Se
			deconnecter</a>

	</div>
</body>
</html>