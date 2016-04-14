<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers Spetial Template</title>
</head>
<body>
	<table>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td><a href="${customer.id}">${customer.id}</a></td>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td><button type="submit">Delete</button></td>
			</tr>
		</c:forEach>
	</table>
	<button type="button">Create</button>
</body>
</html>