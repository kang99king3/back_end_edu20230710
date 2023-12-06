package com.hk.fintech.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
	public String authResult(String code,Model model) throws IOException {
		System.out.println("인증후 받은 code:"+code);
		
		HttpURLConnection conn=null;// api에서 제공하는 데이터를 받기 위한 연결 객체
		JSONPObject result=null; //받아온 데이터를 json으로 저장할 객체
		
		//인증받고 얻은 code를 통해 토큰을 요청하여 발급받는다.
		URL url=new URL("https://testapi.openbanking.or.kr/oauth/2.0/token?"
				       +"code="+code
				       +"&client_id=4987e938-f84b-4e23-b0a2-3b15b00f4ffd"
				       +"&client_secret=3ff7570f-fdfb-4f9e-8f5a-7b549bf2adec"
				       +"&redirect_uri=http://localhost:8087/user/authresult"
				       +"&grant_type=authorization_code"
						);
		
		conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST"); //post로 요청 설정
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setDoOutput(true); //데이터를 가져온다면 true로 설정한다.
		
		// 데이터를 실제로 가져오는 작업
		
		return "authresult";
	}
}











