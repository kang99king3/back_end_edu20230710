package com.hk.board.controller;

import java.io.IOException;
import java.nio.charset.CoderMalfunctionError;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.board.daos.HkDao;
import com.hk.board.dtos.HkDto;

@WebServlet("*.board")
public class HkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//인코딩 처리는 filter로 구현했음
		
		//command 구현하기
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String pathInfo=request.getPathInfo();
		StringBuffer requestURL=request.getRequestURL();
		
		//글목록요청    url: boardList.board 
		//글상세보기요청 url: detailBoard.board
		System.out.println(requestURI+"\n"
						  +contextPath+"\n"
						  +pathInfo+"\n"
						  +requestURL.toString());
		
		//1단계
		String command=requestURI.substring(contextPath.length());
		System.out.println("command값:"+command);
		
		//2단계
		HkDao dao=new HkDao();
		
		//3단계 command값 분기
		if(command.equals("/boardList.board")) {//글목록 보여주기
			List<HkDto> list=dao.getAllList();
			request.setAttribute("list", list);
			
			//forward()구현
			dispatch("board/boardList.jsp", request, response);
		}else if(command.equals("/insertBoardForm.board")){//글추가폼이동
 //         sendRedirect로 이동하면 경로가 남는다. /board/*
//			response.sendRedirect("board/insertBoardForm.jsp");
			
			//forward방식으로 응답하자..   *.jsp로 응답할 경우
			dispatch("board/insertBoardForm.jsp", request, response);
			
		}else if(command.equals("/insertBoard.board")) {
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.insertBoard(new HkDto(id,title,content));
			
			
		}
	}
	
	
	//forward구현
	public void dispatch(String url, HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}

}











