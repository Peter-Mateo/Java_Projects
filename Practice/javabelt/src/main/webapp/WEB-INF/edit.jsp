<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Team</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/main.css" type="text/css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<header class="home_header">
		<div class="left">
			<h1>Edit Team</h1>
		</div>
	 	<div class="right">
			<a href="/home">dashboard</a>
		</div>
	</header>
	<div class="container">
		<div class="left">
			<form:form class="form-group" action="/teams/update/${edTeam.id}" method="POST" modelAttribute="edTeam">
				<div>
					<form:label class="form-label" path="teamName">Team Name </form:label>
					<form:input class="form-control" path="teamName" />
					<form:errors path="teamName"/>
				</div>
				<div>
					<form:label class="form-label" path="skillLevel">Skill Level(1-5) </form:label>
					<form:select class="form-select" path="skillLevel">
								<option value=1>1</option>
								<option value=2>2</option>
								<option value=3>3</option>
								<option value=4>4</option>
								<option value=5>5</option>
					</form:select>
					<form:errors path="skillLevel"/>
				</div>
				<div>
					<form:label class="form-label" path="gameDay">Game Day: </form:label>
					<form:select class="form-select" path="gameDay">
								<option value="Monday">Monday</option>
								<option value="Tuesday">Tuesday</option>
								<option value="Wednesday">Wednesday</option>
								<option value="Thursday">Thursday</option>
								<option value="Friday">Friday</option>
								<option value="Saturday">Saturday</option>
								<option value="Sunday">Sunday</option>
					</form:select>
					<form:errors path="gameDay"/>
				</div>
				<br>
				<button style="width: 100%;" class="btn dark">Submit</button>
			</form:form>
			<form action="/teams/delete/${edTeam.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
		</div>
	</div>
</body>
</html>