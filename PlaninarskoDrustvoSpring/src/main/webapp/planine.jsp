<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planine</title>
</head>
<body>
	<h1><b>Planine</b></h1>
	<table>
		<tr>
			<th>Naziv planine: </th>
			<th>Broj domova: </th>
			<th>Broj staza: </th>
			<th>Broj postova: </th>
		</tr>
		<c:forEach items="${planine}" var="p">
			<tr>
				<td>${p.nazivPlanine}</td>
				<td>${fn:length(p.domNts)}-><a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajDomove?planina=${p.idPlanina}">Domovi</a></td>
				<td>${fn:length(p.stazaNts)}-><a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajStaze?planina=${p.idPlanina}">Staze</a></td>
				<td>${fn:length(p.postNts)}-><a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajPostovePlanine?planina=${p.idPlanina}">Postovi</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>