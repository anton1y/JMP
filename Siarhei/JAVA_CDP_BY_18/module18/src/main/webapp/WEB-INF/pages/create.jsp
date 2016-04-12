<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:url value="login?logout" var="logoutUrl" />
		<a href="${logoutUrl}">Log Out</a>
	</c:if>
	<form:form modelAttribute="product" id="createForm" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<form:hidden path="id" />
		<form:label path="name">Name of Product</form:label>
		<form:input path="name" />
		<form:label path="description">Description of Product</form:label>
		<form:input path="description" />
		<button type="submit">Save</button>
	</form:form>
</body>
</html>