<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link  href="../css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="left">
			<form:form class="form-group" action="/shows/update/${edshow.id}" method="POST" modelAttribute="edshow">
				<h1>${edshow.title}</h1>
				<div>
					<form:label class="form-label" path="title">Title </form:label>
					<form:input class="form-control" path="title" />
					<form:errors path="title"/>
				</div>
				<div>
					<form:label class="form-label" path="network">Network: </form:label>
					<form:input class="form-control" path="network" />
					<form:errors path="network"/>
				</div>
				<div>
					<form:label class="form-label" path="description">Description: </form:label>
					<form:textarea class="form-control" path="description" />
					<form:errors path="description"/>
				</div>
				<br>
				<div style="display:flex;">
					<a href="/home" style="width: 100%;" class="btn light">Cancel</a>
					<button style="width: 100%;" class="btn dark">Submit</button>
				</div>
			</form:form>
			<form action="/shows/delete/${edshow.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
		</div>
	</div>
</body>
</html>