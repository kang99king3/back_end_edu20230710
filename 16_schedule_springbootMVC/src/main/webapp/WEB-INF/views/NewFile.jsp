<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String s="aaaa"; %>
<c:choose>
	<c:when test="${s eq 'aaaa' }">
		<h1>${s}</h1>
	</c:when>
	<c:otherwise>
		<h1>zzz</h1>
	</c:otherwise>
</c:choose>
</body>
</html>