<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planinari</title>
</head>
<body>

	<h1>
		<b>Spisak planinara:</b>
	</h1>
	<table>
		<tr>
			<th>Ime: </th>
			<th>Prezime: </th>
			<th>Post: </th>
		</tr>
		<c:forEach items="${planinari}" var="p">
			<tr>
				<td>${p.imePlaninara}</td>
				<td>${p.prezimePlaninara}</td>
				<td><a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajPostove?planinar=${p.idPlaninar}">Prikazi postove</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>