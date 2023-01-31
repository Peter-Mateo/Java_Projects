<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<h1><c:out value="${dojo.name}"/></h1>
	
	<ul>
	<c:forEach var="ninja" items="${dojo.ninjas}">
	
		<li><c:out value="${ninja.firstName}"/> <c:out value="${ninja.lastName}"/></li>
	
	</c:forEach>
	</ul>
	
</body>
</html>