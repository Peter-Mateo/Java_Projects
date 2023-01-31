<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>
	<h1>Results</h1>
	<p><c:out value="${choice}"/></p>
	<p><c:out value="${city}"/></p>
	<p><c:out value="${person}"/></p>
	<p><c:out value="${profession}"/></p>
	<p><c:out value="${livingT}"/></p>
	<p><c:out value="${comment}"/></p>
	<a href="/back">Back</a>
</body>
</html>