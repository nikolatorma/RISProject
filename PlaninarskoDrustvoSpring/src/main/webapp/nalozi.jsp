<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nalog</title>
</head>
<body>

	<h1>
		<b>Korisnik ${planinar.korisnickoPlaninar}</b>
	</h1>

	<h3>Postovani ${planinar.imePlaninara} , ukupan broj Vasih trenutnih rezervacija je: ${fn:length(planinar.rezervacijaNts)} .</h3>

	<table>
		<tr>
			<th>Planina: </th>
			<th>Dom: </th>
			<th>Rezervisano od: </th>
			<th>Do: </th>
			<th></th>
		</tr>
		<c:forEach items="${planinar.rezervacijaNts}" var="r">
			<tr>
				<td>${r.domNt.nazivDoma}</td>
				<td>${r.domNt.planinaNt.nazivPlanine}</td>
				<td>${r.datumOd}</td>
				<td>${r.datumDo}</td>
				<td><a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/brisanjeRezervacije?rezervacija=${r.idRezervacija}">Izbrisi rezervaciju</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>