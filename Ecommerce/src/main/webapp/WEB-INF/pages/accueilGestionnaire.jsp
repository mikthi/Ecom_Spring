<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Accueil</h1>
	</div>

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
				<form action="">
					<input type="submit" value="Afficher Catégories">
				</form>
			</td>
			<td>
				<form action="">
					<input type="submit" value="Afficher Produits">
				</form>
			</td>
		</tr>
	</table>

	<br />
	<a href="<c:url value="/j_spring_security_logout" />"> Se
		deconnecter</a>
</body>
</html>