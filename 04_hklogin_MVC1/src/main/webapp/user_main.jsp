<%@page import="com.hk.user.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css" />
</head>
<%
	UserDto ldto=(UserDto)session.getAttribute("ldto");
%>
<body>
<nav class="navbar">
	<div id="navbar">
		<ul class="navbar-nav">
			<li><a href="index.jsp">HOME</a></li>
			<li>ABOUT</li>
			<li>CONTECT</li>
		</ul>
	</div>
</nav>

<div id="container">
<span><%=ldto.getId()%>[<%=ldto.getRole()%>]님이 로그인 함</span>
</div>

<div class="footer">
	Copyright 1999-2023. 한경닷컴 All rights reserved.
</div>
</body>
</html>



