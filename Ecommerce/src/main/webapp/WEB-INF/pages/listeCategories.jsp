<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>

<script src="<c:url value='/resources/js/bootstrap.js' />"></script>
<script src="<c:url value='/resources/js/npm.js' />"></script>

<title>Catégories</title>
</head>

<body>
	<%@include file="template/header.jsp"%>

	<div class="container" align="center">
		<h2 style="font-family: cursive; font-style: italic;">Affichage
			des catégories</h2>
		<br />

		<table class="table table-hover" style="vertical-align: center">
			<tr bgcolor="grey" style="color: white" align="center">
				<td style="font-weight: bold;">ID</td>
				<td style="font-weight: bold;">Nom</td>
				<td style="font-weight: bold;">Description</td>
				<td class="col-md-1" colspan="2" style="font-weight: bold;">Edition</td>
			</tr>
			<c:forEach var="categ" items="${listeCateg}">
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
					<td>
						<form
							action="supprimerCategorie?IdCategorie=${categ.id_categorie}"
							method="post">
							<button type="submit" class="btn btn-warning btn-lg">Supprimer</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

		<br /> <a style="float: right;"
			href="<c:url value="/j_spring_security_logout" />"> Se
			deconnecter</a>

	</div>


</body>
</html>