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
	<%@include file="template/header.jsp"%>

	<div class="container" align="center">
		<h2 style="font-family: cursive; font-style: italic;">Affichage
			de la catégorie modifiée</h2>
			<br />

		<table class="table table-hover">
			<tr bgcolor="grey" style="color: white" align="center">
				<td style="font-weight: bold;">ID</td>
				<td style="font-weight: bold;">Nom</td>
				<td style="font-weight: bold;">Description</td>
				<td class="col-md-2" style="font-weight: bold;">Edition</td>
			</tr>
			<tr align="center">
				<td>${categ.id_categorie}</td>
				<td>${categ.nom}</td>
				<td>${categ.description}</td>
				<td>
					<form action="formModifCateg?IdCategorie=${categ.id_categorie}"
						method="post">
						<button type="submit" class="btn btn-warning btn-lg">Modifier</button>
					</form>
				</td>
			</tr>
		</table>

		<br /> <a style="float: right;"
			href="<c:url value="/j_spring_security_logout" />"> Se
			deconnecter</a>

	</div>
</body>
</html>