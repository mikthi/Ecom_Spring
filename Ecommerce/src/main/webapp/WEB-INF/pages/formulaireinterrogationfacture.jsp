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
<title>formulatire d'interrogation facture</title>

<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>

<script src="<c:url value='/resources/js/npm.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>

</head>
<body>
<body>
	<div align="center">

		<h1>Insérer le numéro d'identification de la facture</h1>

		<form:form method="post" action="consulterFacture"
			modelAttribute="com">
			<table>
				<tr>
					<td><form:label path="id_commande" />Nombre
						de produit à commander :</td>
					<td><form:input type="number"
							path="id_commande" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

					<td><input class="btn btn-default btn-sm" type="submit"
						value="consulter" /></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>	<a  href="accueil" class="btn btn-default btn-sm"
						type="button"> retour à l'accueil </a></td>
						
					
				</tr>
			</table>
		</form:form>
		</div>
</body>


</html>