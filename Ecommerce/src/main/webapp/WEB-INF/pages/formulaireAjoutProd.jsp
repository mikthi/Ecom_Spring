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
<title>Ajout produit</title>
</head>

<body>
	<%@include file="template/header.jsp"%>

	<div class="container" align="center">
		<h2 style="font-family: cursive; font-style: italic;">Produit à
			ajouter</h2>
		<br />

		<form:form class="form-inline" method="post" action="ajouterProduit"
			modelAttribute="prod">
			<table>
				<tr>
					<td><form:label for="nom" path="nom" />Nom :&nbsp;</td>
					<td><form:input type="text" id="nom" class="form-control"
							path="nom" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><form:label for="description" path="description" />Description
						:&nbsp;</td>
					<td><form:input type="text" id="description"
							class="form-control" path="description" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><form:label for="prix" path="prix" />Prix :&nbsp;</td>
					<td><form:input type="text" id="prix" class="form-control"
							path="prix" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><form:label for="IdCategorie"
							path="categorie.id_categorie" />Catégorie :&nbsp;</td>
					<td><form:select id="IdCategorie" class="form-control" path="categorie.id_categorie" >
							<c:forEach var="categ" items="${listCateg}">
								<form:option value="${categ.id_categorie}">${categ.nom}</form:option>
							</c:forEach>
						</form:select></td>
				</tr>

			</table>
			<br />
			<button type="submit" class="btn btn-warning btn-lg">Valider</button>
		</form:form>

	</div>

</body>


</html>