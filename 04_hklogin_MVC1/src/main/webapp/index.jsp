<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/loginpage.css" />
</head>
<body>
<form action="userController.jsp" method="post">
	<input type="hidden" name="command" value="login"/>
	<h1>Login in</h1>
	<input class="loginVal" type="text" name="id" placeholder="ID" required="required"/>
	<input class="loginVal" type="password" name="password" placeholder="PASSWORD" required="required"/>
	<input type="checkbox" value="remember-me"/><label>아이디 저장</label>
	<button type="submit">Sign in</button>
	<button type="button" onclick="registForm()">Sign Up</button>
</form>
</body>
</html>











