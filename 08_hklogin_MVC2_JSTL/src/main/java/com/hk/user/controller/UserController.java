package com.hk.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hk.user.daos.UserDao;

//url mapping : 클라이언트에서 ~.user라고 요청하면 해당 서블릿이 실행된다.
@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청을 식별하기위해 url로부터 command값을 추출하기 위해 구해준다.
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		
		String command=requestURI.substring(contextPath.length());
		System.out.println("command값:"+command);
		
		//DB 쿼리 작성: DAO 객체 구하기
		UserDao dao=UserDao.getUserDao();//싱글톤패턴 적용
		
		//로그인관리:session객체 구하기
		HttpSession session=request.getSession();
		
		if(command.equals("/registForm.user")) {
			dispatch("registForm.jsp", request, response);
		}
		
	}
	
	//forward구현
	public void dispatch(String url, HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}

	//javascript로 응답 구현
	public void jsForward(String msg,String url
		,HttpServletResponse response) throws IOException {
		
		PrintWriter out=response.getWriter();
		String str="<script type='text/javascript'>" 
				+   "alert('"+msg+"');"
				+   "location.href='"+url+"';"
				+   "</script>";
		out.print(str);
		
	}
}










