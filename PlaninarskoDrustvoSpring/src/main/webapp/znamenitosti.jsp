<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Znamenitosti</title>
</head>
<body>

	<h1>
		<b>Znamenitosti planine ${planina.nazivPlanine}</b>
	</h1>

	<c:forEach items="${znamenitosti}" var="z">
		<table>
			<tr>
				<th>Znamenitost: </th>
				<th>Opis: </th>
				<th>Slike: </th>
				<th>Rezervisite posetu</th>
				<th>Ostavite komentar</th>
			</tr>
			<tr>
				<td>${z.tip}</td>
				<td>${z.opisZnamenitosti}</td>
				<td><c:forEach items="${z.slikeNts}" var="slikez">
						<img src=${slikez.putanjaSZ } width="300" height="250">
					</c:forEach></td>
				<td><a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajTermine?znamenitost=${z.idZnamenitost}">Rezervisi termin</a></td>
				<td>
					<form action="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/komentari?znamenitost=${z.idZnamenitost}&staza=${z.stazaNt.idStaza}&" method="post">
						<textarea rows="8" cols="36" name="komentar"></textarea><br>
						<input type="submit" value="Objavi komentar">
					</form>
				</td>
			</tr>
		</table>
		<table>
			<c:if test="${!empty z.komentarNts}">
				<c:forEach items="${z.komentarNts}" var="k">
					<tr>
						<td>${k.planinarNt.imePlaninara}</td>
						<td style="width: 100%"><span>${k.komentar}</span></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</c:forEach>
</body>
</html>