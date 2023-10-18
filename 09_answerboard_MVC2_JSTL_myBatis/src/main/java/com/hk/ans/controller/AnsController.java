package com.hk.ans.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.ans.daos.AnsDao;
import com.hk.ans.dtos.AnsDto;

@WebServlet("*.board")
public class AnsController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//09_answerboard_MVC2_JSTL_myBatis/*.board
		//09_answerboard_MVC2_JSTL_myBatis
		//--------------------------------/*.board---> command값
		//1단계:command값 구하기
		String command=request.getRequestURI()
				           .substring(request.getContextPath().length());
		System.out.println("command값:"+command);
		
		//2단계:Dao객체생성
		AnsDao dao=new AnsDao();
		
		//3단계:if 분기
		if(command.equals("/boardList.board")) {//글목록 조회
			
			//글목록으로 이동하면 쿠키 rseq값을 삭제하자
			Cookie cookie=getCookie("rseq", request);
			if(cookie!=null) {
				cookie.setMaxAge(0);//유효기간 0 --> 삭제됨
				response.addCookie(cookie);//클라이언트로 변경사항을 전달
			}
			//쿠키 삭제 코드 종료------------
			
			List<AnsDto>list=dao.getAllList();
			request.setAttribute("list", list);
			dispatch("board/boardList.jsp", request, response);
		}else if(command.equals("/insertForm.board")) {//글추가폼 이동
			dispatch("board/insertForm.jsp", request, response);
		}else if(command.equals("/insertBoard.board")) {//글추가하기
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.insertBoard(new AnsDto(id, title, content));
			if(isS) {
				response.sendRedirect("boardList.board");
			}else {
				request.setAttribute("msg", "글추가실패");
				dispatch("error.jsp", request, response);
			}
		}else if(command.equals("/detailBoard.board")) {//상세내용조회
			int seq=Integer.parseInt(request.getParameter("seq"));
			AnsDto dto=dao.getBoard(seq);
			
			//쿠키객체 가져오기 : 반환타입 - 배열
			// getName() : 쿠키 이름 구하기
			// getValue() : 쿠키 값 구하기
//			Cookie[] cookies=request.getCookies();
//			String s=null;
//			for (int i = 0; i < cookies.length; i++) {
//				if(cookies[i].getName().equals("rseq")) {
//					s=cookies[i].getValue();
//				}
//			}
			//getCookie메서드 구현해서 활용하기
			Cookie cookieObj=getCookie("rseq", request);
			
			String s=null;
			if(cookieObj!=null) {//cookie가 null이 아닐 경우 실행
				s=cookieObj.getValue();				
			}
			
			//"rseq"라는 이름의 값이 있는지 확인(쿠키값이 없는 경우)
			if(s==null||!s.equals(String.valueOf(seq))) {
				//쿠키객체 생성하기
				//                    cookie에 값을 저장할때 타입은 String 이다
				Cookie cookie=new Cookie("rseq", String.valueOf(seq));
				cookie.setMaxAge(60*10);//유효기간 설정
				response.addCookie(cookie);//클라이언트로 cookie객체 전달
				
				//---조회수 올리기 코드
				dao.readCount(seq);//조회수 증가
				//--조회수 코드 종료
			}
			
			
			
			
			
			
			
			
			
			request.setAttribute("dto", dto);
			dispatch("board/detailBoard.jsp", request, response);
		}else if(command.equals("/updateBoardForm.board")) {//수정폼이동
			int seq=Integer.parseInt(request.getParameter("seq"));
			AnsDto dto=dao.getBoard(seq);
			
			request.setAttribute("dto", dto);
			dispatch("board/updateBoard.jsp", request, response);
		}else if(command.equals("/updateBoard.board")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.updateBoard(new AnsDto(seq,title,content));
			if(isS) {
				response.sendRedirect("detailBoard.board?seq="+seq);
			}else {
				request.setAttribute("msg", "수정실패");
				dispatch("error.jsp", request, response);
			}
		}
		
	}
	
	//forward구현
	public void dispatch(String url,HttpServletRequest request,
			                        HttpServletResponse response) 
			                  throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//getCookie 기능 구현
	public Cookie getCookie(String cookieName, HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		Cookie cookie=null;
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals(cookieName)) {
				cookie=cookies[i];
			}
		}
		return cookie;
	}
}














