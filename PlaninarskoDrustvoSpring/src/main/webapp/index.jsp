<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>
		<b>Dobro dosli na stranicu planinarskog drustva, molimo Vas da se ulogujete!</b>
	</h1>
	<form action="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/logIn" method=post>
		Korisnicko ime: <input type="text" name="korisnickoPlaninar"><br>
		Sifra: <input type="password" name="sifraPlaninara"><br> <input
			type="submit" value="LogIn">
	</form>
	<c:if test="${!empty poruka}">
		<p>${poruka}</p>
	</c:if>
</body>
</html>