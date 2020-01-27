<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rezervacija mesta u domu</title>
</head>
<body>

	<h1>
		<b>Rezervacija datuma za boravak u planinarskom domu</b>
	</h1>
	<br>

	<h2>Postovani ${planinar.korisnickoPlaninar}, molimo Vas da izaberete datum kada biste zeleli da boravite u domu ${dom.nazivDoma} na planini ${planina.nazivPlanine}</h2>
	<br>

	<form action="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/rezervacija" method="post">
		<input type="date" name="datumOd"><br>
		<input type="date" name="datumDo"><br>
		<input type="submit" value="Rezervisi termin">
	</form>
	<h3>${poruka}</h3>
</body>
</html>