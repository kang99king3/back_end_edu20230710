<%@page import="com.hk.user.dtos.UserDto"%>
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
	}else if(command.equals("idChk")){//ID 중복체크하기
		String id=request.getParameter("id");
		String resultId=dao.idCheck(id);//중복된 ID의 결과 받기(결과없으면 null)
		
		request.setAttribute("resultId", resultId);
		pageContext.forward("idChkForm.jsp");
	}else if(command.equals("addUser")){//회원가입 하기
		//회원가입 폼에서 입력한 정보를 받기
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		
		boolean isS=dao.insertUser(new UserDto(id,name,password,address,email));
		if(isS){
			%>
			<script type="text/javascript">
				alert("회원에 가입이 되셨습니다.");
				location.href="index.jsp";
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
				alert("회원 가입 실패입니다.ㅜㅜ");
				location.href="userController.jsp?command=registForm";
			</script>
			<%
		}
	}else if(command.equals("login")){
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		//ID,PW에 해당하는 회원정보 조회--> 존재하면 회원 --> 로그인 실행
		UserDto dto=dao.getLogin(id, password);
		
		if(dto==null||dto.getId()==null){//회원이 존재하지 않는 경우
			response.sendRedirect("index.jsp");
		}else{
			//회원이라면
			session.setAttribute("ldto", dto);//sessionScope에 저장(로그인정보)
			session.setMaxInactiveInterval(10*60);//10분간 요청이 없으면 세션 삭제
			
			//등급[ADMIN, MAMANGER, USER]을 확인해서 해당 MAIN 페이지로 이동하자
			if(dto.getRole().toUpperCase().equals("ADMIN")){
				//나중에 처리
			}else if(dto.getRole().toUpperCase().equals("MANAGER")){
				
			}else if(dto.getRole().toUpperCase().equals("USER")){
				response.sendRedirect("user_main.jsp");
			}
		}
	}
%>
</body>
</html>








