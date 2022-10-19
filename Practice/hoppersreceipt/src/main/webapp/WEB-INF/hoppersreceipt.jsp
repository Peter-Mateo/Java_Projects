<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<h1>Customer Name: <c:out value="${name}"/></h1>
	<h3>Item name: <c:out value="${item}"/></h3>
	<h3>Price: $<c:out value="${price}"/></h3>
	<h3>Description: <c:out value="${description}"/></h3>
	<h3>Vendor: <c:out value="${vendor}"/></h3>
</body>
</html>