<%@page import="com.hk.user.daos.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command=request.getParameter("command");

	UserDao dao=UserDao.getUserDao();//클래스명.메서드():static메서드 호출방법
	
	if(command.equals("registForm")){//회원가입폼으로 이동
		response.sendRedirect("registForm.jsp");
	}
%>
</body>
</html>








