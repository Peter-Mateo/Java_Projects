<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Team</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link  href="../css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<header class="home_header">
		<div class="left">
			<h1><c:out value="${team.teamName}"/></h1>
		</div>
	 	<div class="right">
			<a href="/home">dashboard</a>
		</div>
	</header>
	<br>
			<h3 class="px-5">Team Name: <c:out value="${team.teamName}"/></h3>
			<h3 class="px-5">Skill Level: <c:out value="${team.skillLevel}"/></h3>
			<h3 class="px-5">Game Day: <c:out value="${team.gameDay}"/></h3>
			<h3 class="px-5">Players</h3>
			<br>
			
	<hr>
	<form:form class="form-group mx-5" action="/teams/add/player/${team.id}/${user.id}" method="POST" modelAttribute="player">
		<h3 class="mx-5">Add Player: </h3>
		<div>
			<form:label class="form-label mx-5" path="playerName">Player Name: </form:label>
			<form:input class="form-control mx-5" path="playerName" />
			<form:errors path="playerName"/>
		</div>
		<br>
		<button class="mx-5">Submit</button>
	</form:form>
	<a href="/teams/${team.id}/edit">Edit</a>
	<form action="/teams/delete/${team.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
</body>
</html>