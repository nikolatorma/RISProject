<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pocetna strana</title>
</head>
<body>

	<c:if test="${!empty planinar}">

		<h1>
			<b>${planinar.imePlaninara} ${planinar.prezimePlaninara}, uspesno ste se ulogovali.</b>
		</h1>
		<br>
	</c:if>

	<pre>
		<a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajPlanine">Lista planina</a><br>
		<a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajPlaninare">Lista planinara</a>
	</pre>
	<br>

	<c:if test="${!empty poruka}">
		<h4>
			<b>Vasa rezervacija je uspesno sacuvana.</b>
		</h4>
	</c:if>
</body>
</html>