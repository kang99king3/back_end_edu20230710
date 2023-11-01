package com.hk.ansboard;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.ansboard.dtos.AnsDto;
import com.hk.ansboard.service.IAnsService;
import com.hk.ansboard.utils.Paging;

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
	
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
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
		
		//글목록 구하기
		List<AnsDto>list=ansService.getAllList(pnum);
		model.addAttribute("list", list);
		
		//페이지 수 구하기 
		int pcount=ansService.getPCount();
		model.addAttribute("pcount", pcount);
		
		//---페이지에 페이징 처리 기능 추가
		//필요한 값: 페이지수, 페이지번호, 페이지범위(페이지수)
		Map<String, Integer>map=Paging.pagingValue(pcount, pnum, 10);
		model.addAttribute("pMap", map);
		
		return "board/boardList";//"WEB-INF/views/"+boardList+".jsp"
	}
	
	@RequestMapping(value = "/detailBoard.do",method = RequestMethod.GET)
	public String detailBoard(int seq,Model model
							,HttpServletRequest request
							,HttpServletResponse response) {
		
		//상세내용 조회
		AnsDto dto=ansService.getBoard(seq);
		model.addAttribute("dto", dto);
		
		String s=null;
		
		//getCookie메서드 구현해서 활용하기
//		Cookie cookieObj=getCookie("rseq", request);
		
//		if(cookieObj!=null) {//cookie가 null이 아닐 경우 실행
//			s=cookieObj.getValue();				
//		}
		
		//"rseq"라는 이름의 값이 있는지 확인(쿠키값이 없는 경우)
		if(s==null||!s.equals(String.valueOf(seq))) {
			//쿠키객체 생성하기
			//                    cookie에 값을 저장할때 타입은 String 이다
			Cookie cookie=new Cookie("rseq", String.valueOf(seq));
			cookie.setMaxAge(60*10);//유효기간 설정
			response.addCookie(cookie);//클라이언트로 cookie객체 전달
			
			//---조회수 올리기 코드
			ansService.readCount(seq);//조회수 증가
			//--조회수 코드 종료
		}
		
		return "board/detailBoard";
	}
	
	@RequestMapping(value = "/insertBoardForm.do",method = RequestMethod.GET)
	public String insertBoardForm() {
		return "board/insertBoardForm";
	}
	
	@GetMapping(value = "/home.do")
	public String home() {
		System.out.println("HOME요청");
		return "home";
	}
}





