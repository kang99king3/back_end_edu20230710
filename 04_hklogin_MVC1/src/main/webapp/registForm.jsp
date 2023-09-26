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
<script type="text/javascript">
	//ID 중복체크
	function idChk(){
		//입력된 ID값 구하기
		var id=document.getElementsByName("id")[0].value;
		if(id==""){
			alert("아이디를 입력하세요");
		}else{
			window.open("userController.jsp?command=idChk"
					+"&id="+id,"아이디 확인", "width=300px,height=300px");
		}
	}
</script>
</head>
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
<div class="container">
	<h1>회원 가입</h1>
	<form class="form-group" action="userController.jsp" method="post">
		<input type="hidden" name="command" value="addUser"/>
		<input type="text" name="id" placeholder="ID"/>
		<span id="idChk" style="display: none;">n</span>
		<a href="#" onclick="idChk()">중복체크</a>
		<input type="text" name="name" placeholder="이름"/>
		<input type="password" name="password" placeholder="PASSWORD"/>
		<input type="password" name="password2" placeholder="PASSWORD확인"/>
		<input type="text" name="address" placeholder="주소"/>
		<input type="email" name="email" placeholder="email"/>
		<button type="submit">가입완료</button>
		<button type="button" onclick="location.href='index.jsp'" >메인</button>
	</form>
</div>

<div class="footer">
	Copyright 1999-2023. 한경닷컴 All rights reserved.
</div>
</body>
</html>














