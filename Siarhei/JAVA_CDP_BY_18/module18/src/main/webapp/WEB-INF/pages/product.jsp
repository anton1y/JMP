<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<span>Return <a href="/training">to all products</a>
	</span>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:url value="login?logout" var="logoutUrl" />
		<a href="${logoutUrl}">Log Out</a>
	</c:if>
	<c:if test="${not empty product}">
		<h2>Product info</h2>
		<table>

			<tr>
				<td>Product id :</td>
				<td>${product.id}</td>

			</tr>
			<tr>
				<td>Product name :</td>
				<td>${product.name}</td>

			</tr>
			<tr>
				<td>Product description :</td>
				<td>${product.description}</td>
			</tr>
			<sec:authorize ifAnyGranted="ROLE_ADMIN">
				<tr>
					<td>Delete Product :</td>
					<td><a href="${product.id}/delete">Delete Product</a></td>
				</tr>
			</sec:authorize>

		</table>
	</c:if>
</body>
</html>