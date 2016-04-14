<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
</head>
<body>
<form:form modelAttribute="customer" method="post" action="/MVC/customers/save/">
	<table>

		<tr>
			<td>id :</td>
			<td><form:input path="id" /></td>

		</tr>
		<tr>
			<td>firstName :</td>
			<td><form:input path="firstName" /></td>

		</tr>
		<tr>
			<td>lastName :</td>
			<td><form:input path="lastName" /></td>
		</tr>
	</table>
	<button type="submit">Save</button>
</form:form>
</body>
</html>