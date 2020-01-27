<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staze</title>
</head>
<body>

<h1><b>Staze na planini ${planina.nazivPlanine}</b></h1>

<table>
<tr>
<th>Staza:</th>
<th>Tezina staze:</th>
<th>Mapa:</th>
<th>Znamenitosti</th>
</tr>
<c:forEach items="${staze}" var="s">
	<tr>
	<td>${s.opisStaze}</td>
	<td>${s.tezinaStaze}</td>
	<td><c:forEach items="${s.mapaNts}" var="mapa"><img src=${mapa.putanjaM } width="300" height="300"></c:forEach></td>
	<td><a href="/PlaninarskoDrustvoSpring/PlaninarskoDrustvoController/izlistajZnamenitosti?staza=${s.idStaza}">Znamenitosti</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>