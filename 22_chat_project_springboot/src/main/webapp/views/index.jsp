<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
</head>
<body>
<h1>HOME</h1>
<form action="/chatform" method="post">
<label>ROOM:</label><input type="text" name="roomNo"> <br/>
<label>ID:</label><input type="text" name="userId" >
<input type="submit" value="시작"/>
</form>

</body>
</html>