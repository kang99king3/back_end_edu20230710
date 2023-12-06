package com.hk.fintech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.fintech.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//회원가입폼 이동
	@GetMapping("/signup")
	public String signUp() {
		return "signup";
	}
	
	//사용자 인증을 완료하면 code들을 반환해준다.
	//반환받은 code를 이용해서 토큰 발급 요청을 진행한다.
	@GetMapping("/authresult")
	public String authResult(String code,Model model) {
		System.out.println("인증후 받은 code:"+code);
		return "authresult";
	}
}











