<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facture</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>

<script src="<c:url value='/resources/js/npm.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>

</head>
<body>

	<h1 align="center">Facture</h1>



	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div align="center" class="panel-heading">Commande n°${com.id_commande}</div>

		<!-- Table -->
		<table align="center" class="table">
			<thead style="border-bottom: solid 2px black;">
				<tr>
					<th>Nom</th>
					<th>Prix</th>
					<th>Quantité</th>
				
				</tr>
			</thead>
			<tbody style="border-top: solid 2px;">
				<c:forEach var="listeProduit" items="${listeProduit}">
					<tr>
						<td>${listeProduit.nom}</td>
						<td><fmt:formatNumber value="${listeProduit.prix}"
								type="currency" currencySymbol="€" /></td>
						<td>${com.produitCommande[listeProduit.id_produit]}</td>
	
					</tr>
				</c:forEach>
			</tbody>
			<tfoot style="border-top: solid 2px;">

				<tr>
					<td>Votre facture s'élève à</td>
					<td><strong><fmt:formatNumber
								value="${montantTotal}" type="currency"
								currencySymbol="€" /></strong></td>
								<td>	<a  href="accueil" class="btn btn-default btn-sm"
						type="button"> retour à l'accueil </a></td>
				</tr>
			</tfoot>

		</table>
	</div>
</body>
</html>