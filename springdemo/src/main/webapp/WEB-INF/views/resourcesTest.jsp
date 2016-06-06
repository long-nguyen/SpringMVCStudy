<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Resource example</title>

<link href='<c:url value="/styles/common.css" />' rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src='<c:url value="scripts/common.js"/>'></script>

</head>
<body>
	<div class="red-text">Red text</div>
	<br>
	<div class="green-text">Green text</div>
	<br>

	<input type="button" class="button" onclick="sayHello();"
		value="Click me!">
	<img alt="" src='<c:url value="/images/test.JPG"></c:url>'>
</body>
</html>