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
	<%@include file="template/header.jsp"%>

	<div class="container" align="center">
		<h2 style="font-family: cursive; font-style: italic;">Catégorie à
			ajouter</h2>
		<br />

		<form:form class="form-inline" method="post" action="ajouterCategorie"
			modelAttribute="categ">
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
			</table>
			<br />
			<button type="submit" class="btn btn-warning btn-lg">Valider</button>
		</form:form>

		<%-- 		<form:form method="post" action="ajouterCategorie" --%>
		<%-- 			modelAttribute="categ"> --%>
		<!-- 			<table> -->
		<!-- 				<tr> -->
		<%-- 					<td><form:label path="nom" />Nom :</td> --%>
		<%-- 					<td><form:input path="nom" /></td> --%>
		<%-- 					<td><form:label path="description" />Description :</td> --%>
		<%-- 					<td><form:input path="description" /></td> --%>
		<!-- 				</tr> -->
		<!-- 			</table> -->
		<!-- 			<br /> -->
		<!-- 			<br /> -->
		<!-- 			<br /> -->
		<!-- 			<input type="submit" value="Valider" /> -->
		<%-- 		</form:form> --%>

	</div>
</body>


</html>