<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>

	<h1>Add a Person</h1>

	<c:url var="addAction" value="/user/add"></c:url>

	<form:form action="${addAction}" commandName="user">
		<table>
			<c:if test="${!empty user.username}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="username">
						<spring:message text="User name" />
					</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty user.username}">
						<input type="submit" value="<spring:message text="Edit Person"/>" />
					</c:if> <c:if test="${empty user.username}">
						<input type="submit" value="<spring:message text="Add Person"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>


	<div align="center">
		<h1>User List</h1>
		<table border="1">
			<th>ID</th>
			<th>User Name</th>
			<th>Email</th>

			<c:forEach var="user" items="${listUsers}" varStatus="status">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td><a href='<c:url value="/user/edit/${user.id}"></c:url>' >Edit</a> 
					<a href='<c:url value="/user/delete/${user.id}"></c:url>' >Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>