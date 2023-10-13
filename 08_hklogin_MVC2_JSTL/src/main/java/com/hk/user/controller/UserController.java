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
import com.hk.user.dtos.UserDto;

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
		
		if(command.equals("/registForm.user")) {//회원가입폼이동
			dispatch("registForm.jsp", request, response);
		}else if(command.equals("/home.user")) {//index(로그인화면)이동
			dispatch("index.jsp", request, response);
		}else if(command.equals("/addUser.user")) {
			//회원가입 폼에서 입력한 정보를 받기
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			
			boolean isS=dao.insertUser(new UserDto(id,name,password,address,email));
			if(isS) {
				jsForward("회원가입성공", "home.user", response);
			}else {
				jsForward("회원가입실패", "registForm.user", response);
			}
		}else if(command.equals("/login.user")) {
			String id=request.getParameter("id");
			String password=request.getParameter("password"); 
			
			UserDto ldto=dao.getLogin(id, password);
			if(ldto==null||ldto.getId()==null) {
				request.setAttribute("msg", "회원이 아닙니다. 가입해주세요");
				dispatch("index.jsp", request, response);
			}else {
				//회원이면 session객체에 회원정보를 저장
				session.setAttribute("ldto", ldto);
				session.setMaxInactiveInterval(10*60);
				
				//회원에 등급에 따라 메인 페이지 이동
				if(ldto.getRole().toUpperCase().equals("ADMIN")) {
					dispatch("admin_main.jsp", request, response);
				}else if(ldto.getRole().toUpperCase().equals("MANAGER")) {
					dispatch("manager_main.jsp", request, response);
				}else if(ldto.getRole().toUpperCase().equals("USER")) {
					dispatch("user_main.jsp", request, response);
				}
			}
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










