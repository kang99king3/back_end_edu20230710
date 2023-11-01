package com.hk.ansboard;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hk.ansboard.service.IAnsService;

@Controller
public class AnsController {

	@Autowired
	private IAnsService ansService;
	
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
	
	public String getAllList(String pnum,Model model
			,HttpServletRequest request
			,HttpServletResponse response) {
		//글목록으로 이동하면 쿠키 rseq값을 삭제하자
		Cookie cookie=getCookie("rseq", request);
		if(cookie!=null) {
			cookie.setMaxAge(0);//유효기간 0 --> 삭제됨
			response.addCookie(cookie);//클라이언트로 변경사항을 전달
		}
		//쿠키 삭제 코드 종료------------
		
		//---페이지번호 유지를 위한 코드----------------------
		//페이지번호를 전달하지 않으면 세션에 저장된 페이지번호를 사용
		HttpSession session=request.getSession();
		if(pnum==null) {
			pnum=(String)session.getAttribute("pnum");//현재 조회중인 페이지번호
		}else {
			//새로 페이지를 요청할 경우 세션에 저장
			session.setAttribute("pnum", pnum);
		}
		//---페이지번호 유지를 위한 코드 종료-------------------
		return "";
	}
	
	
	@GetMapping(value = "/home.do")
	public String home() {
		System.out.println("HOME요청");
		return "home";
	}
}
