package com.hk.ans.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		}else if(command.equals("/detailBoard.board")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			AnsDto dto=dao.getBoard(seq);
			
			request.setAttribute("dto", dto);
			dispatch("board/detailBoard.jsp", request, response);
		}else if(command.equals("/updateBoardForm.board")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			AnsDto dto=dao.getBoard(seq);
			
			request.setAttribute("dto", dto);
			dispatch("board/updateBoard.jsp", request, response);
		}
		
	}
	
	//forward구현
	public void dispatch(String url,HttpServletRequest request,
			                        HttpServletResponse response) 
			                  throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}
}














