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
	style="background-image: url('resources/images/background-image.jpg'); background-repeat: no-repeat; background-size: 80%; background-position: center 80pt;">
</body>
<title>Authentification</title>
</head>

<body>


	<div class="row" align="center">
		<h2 style="font-family: cursive; font-style: italic;">Authentification</h2>
		<br />
		<div class="container">
			<form class="form-inline" action="j_spring_security_check"
				method="post">
				<table>
					<tr>
						<td><label for="login">Login</label></td>
						<td><input type="text" id="login" class="form-control"
							name="j_username"></td>
					</tr>
					<tr>
						<td style="font-size: 50%;">&nbsp;</td>
					</tr>
					<tr>
						<td><label for="password">Password</label></td>
						<td><input type="password" id="password" class="form-control"
							name="j_password"></td>
					</tr>
				</table>
				<br />
				<button type="submit" class="btn btn-warning btn-lg">Se
					connecter</button>
			</form>

		</div>
	</div>
</body>
</html>