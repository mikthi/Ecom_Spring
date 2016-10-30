<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 	Taglib JSTL -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 	Taglib Spring form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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

		<h1>Catégorie à ajouter</h1>

		<form:form method="post" action="ajouterCategorie"
			modelAttribute="categ">
			<table>
				<tr>
					<td><form:label path="nom" />Nom :</td>
					<td><form:input path="nom" /></td>
					<td><form:label path="description" />Description :</td>
					<td><form:input path="description" /></td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<input type="submit" value="Valider" />
		</form:form>

	</div>
</body>


</html>