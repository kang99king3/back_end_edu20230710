<%
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
response.setDateHeader("Expires", 0L); // Do not cache in proxy server
%>
<%@page import="com.hk.user.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
	
	//로그인 정보가 없는 경우 화면 처리--> 로그인 정보가 null인경우 오류가 발생하기 때문
	if(ldto==null){
		pageContext.forward("index.jsp");
	}
	
	//나의 정보
	UserDto dto=(UserDto)request.getAttribute("dto");
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
	<div class="main">
		<div class="lead">
			<span><%=ldto.getId()%>[<%=ldto.getRole()%>]님이 로그인 함</span> |
			<span><a href="userController.jsp?command=myinfo&id=<%=ldto.getId()%>">나의정보</a></span> |
			<span><a href="userController.jsp?command=logout">로그아웃</a></span>
		</div>
		<div class="contents">
			<h1>사용자 페이지</h1>
			<h2>나의 정보</h2>
			<div id="myinfo">
				<table class="table">
					<tr>
						<th>아이디</th>
						<td><%=dto.getId()%></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><%=dto.getName()%></td>
					</tr>
					<tr>
						<th>등급</th>
						<td><%=dto.getRole()%></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><%=dto.getAddress()%></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%=dto.getEmail()%></td>
					</tr>
					<tr>
						<td colspan="2">
							<button>수정</button>
							<button>탈퇴</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="footer">
	Copyright 1999-2023. 한경닷컴 All rights reserved.
</div>
</body>
</html>



