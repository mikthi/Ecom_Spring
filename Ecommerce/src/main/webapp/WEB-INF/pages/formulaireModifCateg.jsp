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
<title>Modification catégorie</title>
</head>
<body>
<body>
	<div align="center">
		<h2>Catégorie à modifier</h2>

		<form:form method="post" action="modifierCategorie"
			modelAttribute="categ">
			<table>
				<tr>
					<td><form:label path="nom" />Nom :</td>
					<td><form:input path="nom" /></td>
					<td><form:label path="description" />Description :</td>
					<td><form:input path="description" /></td>
					<td><form:input type="hidden" path="id_categorie" /></td>
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