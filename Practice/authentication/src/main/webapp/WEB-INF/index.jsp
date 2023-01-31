<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link  href="../css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<header>
		<h1 style="color: purple;">Welcome!</h1>
		<h3>Join our growing community.</h3>
	</header>
	<div class="container">
		<div class="left">
			<form:form class="form-group" action="/register" method="POST" modelAttribute="newUser">
				<h1>Register</h1>
				<div>
					<form:label class="form-label" path="userName">User Name </form:label>
					<form:input class="form-control" path="userName" />
					<form:errors path="userName"/>
				</div>
				<div>
					<form:label class="form-label" path="email">Email: </form:label>
					<form:input class="form-control" path="email" />
					<form:errors path="email"/>
				</div>
				<div>
					<form:label class="form-label" path="password">Password: </form:label>
					<form:input class="form-control" path="password" />
					<form:errors path="password"/>
				</div>
				<div>
					<form:label class="form-label" path="confirm">Confirm PW: </form:label>
					<form:input class="form-control" path="confirm" />
					<form:errors path="confirm"/>
				</div>
				<br>
				<button class="btn dark">Submit</button>
			</form:form>
		</div>
		<div class="right">
			<form:form class="form-group" action="/login" method="POST" modelAttribute="newLogin">
				<h1>Log in</h1>
				<div>
					<form:label class="form-label" path="email">Email: </form:label>
					<form:input class="form-control" path="email" />
					<form:errors path="email"/>
				</div>
				<div>
					<form:label class="form-label" path="password">Password: </form:label>
					<form:input class="form-control" path="password" />
					<form:errors path="password"/>
				</div>
				<br>
				<button class="btn light">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>