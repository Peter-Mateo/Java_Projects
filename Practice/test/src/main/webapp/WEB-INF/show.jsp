<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link  href="../css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="wrapper" style="width: 80%; margin: auto;">
		<header class="home_header">
			<h1><c:out value="${show.title}"/></h1>
			<a href="/home">Back to Dashboard</a>
		</header>
		<br>
		<h3>Network: <c:out value="${show.network}"/></h3>
		<br>
		<h3>Description: <c:out value="${show.description}"/></h3>	
		<br>
		<br>
		<a href="/shows/${show.id}/edit">Edit</a>
		<br>
		<br>
		<form action="/shows/delete/${show.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
		<hr>
	</div>
</body>
</html>