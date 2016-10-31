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
<body
	style="background-image: url('resources/images/background-image.jpg'); background-repeat: no-repeat; background-size: 80%; background-position:center 80pt;">
</body>
<title>Accueil</title>
</head>

<body>
		<div class="row" align="center">
			<h1 style="font-family: cursive; font-style: italic;">E..Commerce</h1>
		</div>
		<br /> <br /> <br />
		<div class="container">

			<div class="row">
				<div class="col-lg-6" align="right">
					<form action="client/index">
						<button type="submit" class="btn btn-success btn-lg">Client</button>
					</form>
				</div>

				<div class="col-lg-6" align="left">
					<form action="gestionnaire/accueil">
						<button type="submit" class="btn btn-danger btn-lg">Gestionnaire</button>
					</form>
				</div>
			</div>
		</div>

</body>
</html>