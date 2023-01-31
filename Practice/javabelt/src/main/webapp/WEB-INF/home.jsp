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
	<header class="home_header">
		<div class="left">
			<h1>Welcome, <c:out value="${user.userName}"/>!</h1>
		</div>
	 	<div class="right">
			<a href="/logout">Logout</a>
		</div>
	</header>
	<div class="wrap">
		<table class="table table-striped">
			<tr>
				<th scope="col">Team Name</th>
				<th scope="col">Skill Level(1-5)</th>
				<th scope="col">Players</th>
				<th scope="col">Game Day</th>
			</tr>
			<c:forEach var="team" items="${teams}">
				<tr>
					<td scope="row"><a href="/teams/${team.id}"><c:out value="${team.teamName}"/></a></td>
					<td><c:out value="${team.skillLevel}"/></td>
					<td>/9</td>
					<td><c:out value="${team.gameDay}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="/teams/new" method="GET">
	    <input style="width:100%;" class="btn dark new_team" type="submit" value="Create New Team">
	</form>
</body>
</html>