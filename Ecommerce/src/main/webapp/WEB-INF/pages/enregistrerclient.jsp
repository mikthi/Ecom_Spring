<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Enregistrer commande</title>


<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>
<script src="<c:url value='/resources/js/npm.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>

</head>
<body>
	<div align="center">

		<h1>Enregistrement de vos coordonnées</h1>


		<form:form action="enregClient" method="post" modelAttribute="client">

			<table>
				<tr>
					<td><form:label path="mail" />mail :</td>
					<td><form:input path="mail" /></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><form:label path="telephone" />Téléphone :</td>
					<td><form:input path="telephone" /></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><form:label path="voie" />Voirie :</td>
					<td><form:input path="voie" /></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><form:label path="ville" />Ville :</td>
					<td><form:input path="ville" /></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><form:label path="codePostal" />Code Postale :</td>
					<td><form:input type="number" path="codePostal" /></td>

				</tr>
								<tr>
					<td><br></td>
				</tr>
			</table>
			<input type="submit" value="enregistrer">
		</form:form>
				
	</div>
</body>
</html>