<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Consulter produits</title>


<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>

<script src="<c:url value='/resources/js/npm.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>

</head>
<body>
	<div class="panel panel-default" align="center">
		<!-- Default panel contents -->
			
		<br />
		<h1>Sélection du produit :</h1>
		<br />

		<h3>${produitSelectionne.nom}</h3>

		<p>
			<br />
		<p>
			<strong> Description :</strong> <br />
		</p>
		<p>${produitSelectionne.description}</p>
		<br />

		<form:form method="post" action="ajouterProduitPanier"
			modelAttribute="panier">
			<table>
				<tr>
					<td><form:label path="quantiteProdSelectionneACommander" />Nombre
						de produit à commander :</td>
					<td><form:input type="number"
							path="quantiteProdSelectionneACommander" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

					<td><input class="btn btn-default btn-sm" type="submit"
						value="Commander" /></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>	<a  href="accueil" class="btn btn-default btn-sm"
						type="button"> retour à l'accueil </a></td>
						
					
				</tr>
			</table>
		</form:form>

	</div>

</body>
</html>