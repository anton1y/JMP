<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html" session="true" %>
<html>
<head>
<title>Products</title>
</head>
<body>
	<sec:authorize ifAnyGranted="ROLE_ADMIN">
		<span>You can create a <a href="createForm">new Product</a> 
	</span>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">You should <a href="training/login">login</a> for create or delete product</sec:authorize>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:url value="login?logout" var="logoutUrl" />
		<a href="${logoutUrl}">Log Out</a>
	</c:if>
		<c:if test="${not empty sessionScope.lastProductSelection}">
		or you can return to your <a href="${sessionScope.lastProductSelection}">last product</a>
		</c:if>
	<c:if test="${not empty products}">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><a href="${product.id}">${product.id}</a></td>
						<td>${product.name}</td>
						<td>${product.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
