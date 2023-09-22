<%@page import="com.hk.board.dtos.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.board.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//1단계:command 값 받기 - 어떤 요청인지 확인을 위해 값을 받는다
	String command=request.getParameter("command");

	//2단계:DAO 객체 생성 - DB관련 작업 수행을 위해 준비..
	HkDao dao=new HkDao();
	
	//3단계:command값 확인해서 분기 실행(요청분기)
	if(command.equals("boardList")){//글목록 요청 처리
		//5단계:dao메서드 실행
		List<HkDto> list=dao.getAllList();
		//6단계:Scope객체에 담기
		request.setAttribute("list", list);//requestScope에 저장: "list":list
		//7단계:페이지 이동
		pageContext.forward("boardList.jsp");
	}else if(command.equals("insertBoardForm")){//글추가폼으로 이동 
		response.sendRedirect("insertBoardForm.jsp");
	}else if(command.equals("insertBoard")){//글추가하기 실행
		//4단계:파리미터 받기
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		boolean isS=dao.insertBoard(new HkDto(id,title,content));
		if(isS){
			%>
			<script type="text/javascript">
				alert("글을 추가합니다.");
				location.href="hkController.jsp?command=boardList";//글추가하고, 글목록 페이지로 이동하기
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
				alert("글추가실패!");
				location.href="hkController.jsp?command=insertBoardForm";//글추가 실패하면, 글추가 페이지로 이동하기
			</script>
			<%
		}
	}
	
%>
</body>
</html>










