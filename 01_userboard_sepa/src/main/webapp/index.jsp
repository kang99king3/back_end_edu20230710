<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{text-decoration: none;}
</style>
</head>
<body>
<h1>회원 관리 시스템</h1>
<p><a href="userList.jsp">(1) 회원 조회(조회 후 수정/삭제 가능)</a></p>
<p><a href="userInsertForm.jsp">(2) 신규회원 등록</a></p>

<form action="userUpdateForm.jsp" method="get">
	<label>(3) 회원수정-회원아이디:</label>
	<input type="text" name="userId"/>
	<input type="submit" value="수정"/>
</form>
<br/>
<form action="" method="get">
	<label>(4) 회원삭제-회원아이디:</label>
	<input type="text" name="userId"/>
	<input type="submit" value="삭제"/>
</form>
</body>
</html>





