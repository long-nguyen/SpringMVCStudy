<!-- Phải có tag lib này để dùng thư viện jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello boy:${name} 
<br>
Your email is: ${email} 
<br>
<a href='<c:url value="/res"/>' >Test resources view</a>  

<br>
<a href='<c:url value="/users"/>' >Test DAO view </a>

<br>
<a href='<c:url value="/testTags"/>' >Test jquery</a> 
<br>
<a href='<c:url value="/exception_custom"/>' >Test Custom Exception</a> 
<a href='<c:url value="/exception_bysystem"/>' >Test General Exception</a>
</body>
</html>