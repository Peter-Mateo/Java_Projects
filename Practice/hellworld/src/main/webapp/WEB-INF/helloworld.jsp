<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>It Works!</title>
</head>
<body>
	<h1>Welcome User!</h1>
	<br>
	<br>
	<h3>Send an Omikuji!</h3>
    <form action='/login' method='POST'>
		<label for="numChoice">Pick any number from 5 to 25</label>
		<input type="number" name="numChoice" id="numChoice">
		<label for="city">Enter the name of any city.</label>
		<input type="text" name="city" id="city">
		<label for="person">Enter the name of any person.</label>
		<input type="text" name="person" id="person">
		<label for="profession">Enter professional endeavor or hobby.</label>
		<input type="text" name="profession" id="profession">
		<label for="livingT">Enter any type of living thing.</label>
		<input type="text" name="livingT" id="livingT">
		<label for="comment">Enter any type of living thing.</label>
		<textarea rows="4" cols="4" name="comment" id="comment"></textarea>
		<button>Submit</button>
    </form>
</body>
</html>