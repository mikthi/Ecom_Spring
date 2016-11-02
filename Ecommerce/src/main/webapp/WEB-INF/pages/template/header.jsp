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
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery-3.1.1.js' />"></script>

<script src="<c:url value='/resources/js/bootstrap.js' />"></script>
<script src="<c:url value='/resources/js/npm.js' />"></script>
<style type="text/css">
.errors{
color:red; margin-left: 5pt; font-style: italic;}
</style>
</head>

<body>

	<div class="row" align="center" style="margin-top: 5px">
		<div class="container: 'body'">
			<div class="row">
				<div class="col-lg-4">
					<table>
						<tr>
							<td>
								<form action="listeCategories">
									<button type="submit" class="btn btn-success btn-lg">Afficher
										Catégories</button>
								</form>
							</td>
							<td>
								<form action="listeProduits">
									<button type="submit" class="btn btn-success btn-lg">Afficher
										Produits</button>
								</form>
							</td>
						</tr>
					</table>
				</div>
				<div class="col-lg-1"></div>
				<div class="col-lg-2" align="right">
					<form action="chercherProduit" method="post">
						<table>
							<tr>
								<td><input type="text" name="motCle" class="form-control"></td>
								<td>
									<button type="submit" class="btn btn-success btn-lg">
										<span class="glyphicon glyphicon-search"></span>
									</button>
								</td>
							</tr>
						</table>
					</form>
				</div>

				<div class="col-lg-1"></div>
				<div class="col-lg-4">
					<table>
						<tr>
							<td>
								<form action="formAjoutCateg">
									<button type="submit" class="btn btn-success btn-lg">Ajouter
										Catégorie</button>
								</form>
							</td>
							<td>
								<form action="formAjoutProd">
									<button type="submit" class="btn btn-success btn-lg">Ajouter
										Produit</button>
								</form>
							</td>
						</tr>
					</table>
				</div>
			</div>

		</div>
	</div>

</body>

</html>