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
		<h2>Produit � ajouter</h2>
	</div>

	<form:form method="post" action="ajouterProduit" modelAttribute="prod">
		<table>
			<tr>
				<td><form:label path="nom" />Nom :</td>
				<td><form:input path="nom" /></td>
				<td><form:label path="description" />Description :</td>
				<td><form:input path="description" /></td>
				<td><form:label path="prix" />Prix :</td>
				<td><form:input path="prix" /></td>
				<td><form:label path="categorie.id_categorie" />Cat�gorie :</td>
				<td><form:input path="categorie.id_categorie" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Ajouter" /></td>
			</tr>
		</table>
	</form:form>
</body>


</html>