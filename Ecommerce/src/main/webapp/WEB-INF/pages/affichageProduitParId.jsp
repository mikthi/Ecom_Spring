<!DOCTYPE html>

<html>

<head>
<title>Produit modifié</title>
</head>

<body>
	<%@include file="template/header.jsp"%>

	<div class="container" align="center">
		<h2 style="font-family: cursive; font-style: italic;">Affichage
			du produit modifié</h2>
		<br />

		<table class="table table-hover">
			<tr bgcolor="grey" style="color: white" align="center">
				<td style="font-weight: bold;">ID</td>
				<td style="font-weight: bold;">Catégorie</td>
				<td style="font-weight: bold;">Nom</td>
				<td style="font-weight: bold;">Description</td>
				<td style="font-weight: bold;">Prix</td>
				<td style="font-weight: bold;">Edition</td>
			</tr>
			<tr align="center">
				<td>${prod.id_produit}</td>
				<td>${prod.categorie.nom}</td>
				<td>${prod.nom}</td>
				<td>${prod.description}</td>
				<td>${prod.prix}&euro;</td>
				<td>
					<form action="formModifProd?IdProduit=${prod.id_produit}"
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