<!DOCTYPE html>

<html>

<head>
<title>Modification catégorie</title>
</head>

<body>
	<%@include file="template/header.jsp"%>

	<div class="container" align="center">
		<h2 style="font-family: cursive; font-style: italic;">Catégorie à
			modifier</h2>
		<br />

		<form:form class="form-inline" method="post"
			action="modifierCategorie" modelAttribute="categ">
			<table>
				<tr>
					<td><form:label for="nom" path="nom" />Nom :&nbsp;</td>
					<td><form:input type="text" id="nom" class="form-control"
							path="nom" /></td>
					<td><form:errors cssClass="errors" path="nom" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><form:label for="description" path="description" />Description
						:&nbsp;</td>
					<td><form:input type="text" id="description"
							class="form-control" path="description" /></td>
					<td><form:errors cssClass="errors" path="description" /></td>
					<td><form:input type="hidden" path="id_categorie" /></td>
				</tr>
			</table>
			<br />
			<button type="submit" class="btn btn-warning btn-lg">Valider</button>
		</form:form>

	</div>

</body>

</html>