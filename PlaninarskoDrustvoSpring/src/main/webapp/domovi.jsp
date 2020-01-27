<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Domovi</title>
</head>
<body>

	<h1>
		<b>Domovi na planini ${planina.nazivPlanine}</b>
	</h1>
	<table>
		<tr>
			<th>Naziv doma: </th>
			<th>Kapacitet doma: </th>
			<th>Broj trenutno slobodnih mesta u domu: </th>
		</tr>
		<c:forEach items="${domovi}" var="d">
			<tr>
				<td>${d.nazivDoma}</td>
				<td>${d.kapacitetDoma}</td>
				<td>${d.brojSlobodnihMesta}</td>
				<td><a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajRezervacije?dom=${d.idDom}">Rezervisi</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<h3>Ovde mozete ostaviti Vase utiske:</h3>
	<form action="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/postovi" method="post" enctype="multipart/form-data">
		<textarea rows="8" cols="80" name="tekst"></textarea><br>
		<input type="file" name="picture" size="50"><br>
		<input type="submit" value="Objavi post">
	</form>
</body>
</html>