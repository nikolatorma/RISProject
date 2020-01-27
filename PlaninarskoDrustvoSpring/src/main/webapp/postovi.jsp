<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Postovi</title>
</head>
<body>

	<h1>
		<b>Postovi</b>
	</h1>

	<table>
		<tr>
			<th>Planinar: </th>
			<th>Planina: </th>
			<th>Izvestaj: </th>
			<th>Slika: </th>
		</tr>
		<c:forEach items="${postovi}" var="p">
			<tr>
				<td>${p.planinarNt.korisnickoPlaninar}</td>
				<td>${p.planinaNt.nazivPlanine}</td>
				<td>${p.izvestaj}</td>
				<td><c:forEach items="${p.putanjaSP}" var="s"><img src=${s.putanjaSP } width="300" height="300">
					</c:forEach></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>