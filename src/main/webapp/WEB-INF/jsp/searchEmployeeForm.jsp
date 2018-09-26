<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<h1>Search New Employee</h1>
<form:form action="searchForEmployee" method="post" modelAttribute="employee">
<form:label path="employeeId"> Employee Id:</form:label>
<form:input path="employeeId"/><br>
<input type="submit" value="SearchEmployee" />
</form:form>
</html>