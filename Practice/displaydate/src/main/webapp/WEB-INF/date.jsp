<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.time.LocalDateTime" %>
<%@ page import = "java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/dateAlert.js"></script>
<meta charset="ISO-8859-1">
<title>Date</title>
</head>
<body>
	<!-- Creates the date -->
	<%
	LocalDateTime datetime = LocalDateTime.now();
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
	String formatedDate = datetime.format(dtformat);
	%>
	<h1 id="blue"> <%=formatedDate%> </h1>
</body>
</html>