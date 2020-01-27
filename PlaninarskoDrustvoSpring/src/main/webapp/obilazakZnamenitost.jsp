<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rezervacija termina za obilazak znamenitosti</title>
</head>
<body>

	<h1>
		<b>Rezervacija termina za obilazak znamenitosti</b>
	</h1>
	<br>

	<h2>Postovani ${planinar.korisnickoPlaninar}, molimo Vas da izaberete datum kada biste zeleli da posetite ${znamenitost.tip} na planini ${planina.nazivPlanine}</h2>
	<br>

	<form action="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/rezervacijaTermina" method="post">
		<input type="date" name="datumObilaska"><br>
		<input type="submit" value="Rezervisi termin">
	</form>
	<h3>${poruka}</h3>
</body>
</html>