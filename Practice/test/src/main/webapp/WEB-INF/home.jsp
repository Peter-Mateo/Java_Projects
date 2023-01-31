<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link  href="../css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<header class="home_header" style="width: 80%; margin: auto;">
		<div class="left">
			<h1>Welcome, <c:out value="${user.userName}"/>!</h1>
		</div>
	 	<div class="right">
			<a href="/logout">Logout</a>
		</div>
	</header>
	<div class="wrap" style="width: 80%; margin: auto;">
		<table class="table table-striped">
			<tr>
				<th scope="col">Show</th>
				<th scope="col">Network</th>
			</tr>
			<c:forEach var="show" items="${shows}">
				<tr>
					<td scope="row"><a href="/shows/${show.id}"><c:out value="${show.title}"/></a></td>
					<td><c:out value="${show.network}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="/shows/new" method="GET" style="width: 80%; margin: auto;">
	    <input style="width:100%;" class="btn dark new_team" type="submit" value="Create New Team">
	</form>
</body>
</html>