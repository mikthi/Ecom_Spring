<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catégorie</title>
</head>
<body>
	<div align="center">
		<h1>Affichage catégorie</h1>


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
					<form action="">
						<input type="submit" value="Rechercher Produit">
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

		<table>
			<tr bgcolor="grey" style="color: white">
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Edition</th>
			</tr>
			<tr>
				<td>${categ.id_categorie}</td>
				<td>${categ.nom}</td>
				<td>${categ.description}</td>
				<td>
					<form action="formModifCateg?IdCategorie=${categ.id_categorie}"
						method="post">
						<input type="submit" value="Modifier">
					</form>
				</td>
			</tr>
		</table>

		<br /> <a href="<c:url value="/j_spring_security_logout" />"> Se
			deconnecter</a>

	</div>
</body>
</html>