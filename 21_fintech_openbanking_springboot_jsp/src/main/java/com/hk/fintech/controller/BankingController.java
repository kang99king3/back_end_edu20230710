package com.hk.fintech.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.fintech.dtos.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/banking")
public class BankingController {
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@ResponseBody // 요청했던 페이지로 응답: return 값을 출력한다.(ajax로 요청했다면 ajax메서드로 값을 전달)
	@GetMapping("/myinfo")
	public JSONObject myInfo(HttpServletRequest request) throws IOException, ParseException {
		System.out.println("나의정보조회[계좌목록]");
		
		HttpURLConnection conn=null;
		JSONObject result=null;
		
		//사용자 일련 번호를 가져오기 위해 session객체 구함
		HttpSession session=request.getSession();
		UserDto ldto=(UserDto)session.getAttribute("ldto");
		int userSeqNo=ldto.getUserseqno();//사용자 일련번호
		String useraccesstoken=ldto.getUseraccesstoken();//접근할 토큰
		URL url=new URL("https://testapi.openbanking.or.kr/v2.0/user/me?"
				      + "user_seq_no="+userSeqNo);
		
		conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization","Bearer "+useraccesstoken);
		conn.setDoOutput(true);
		
		// java에서 사용할 수 있도록 읽어들이는 코드
		BufferedReader br=new BufferedReader(
					new InputStreamReader(conn.getInputStream(),"utf-8")
				);
		
		StringBuilder response=new StringBuilder();
		String responseLine=null;
		
		while((responseLine=br.readLine())!=null) {
			response.append(responseLine.trim());
		}
		
		// json형태의 문자열을 json객체로 변환 -> 값을 가져오기 편함
		result=(JSONObject)new JSONParser().parse(response.toString());
		System.out.println("result:"+result.get("res_list"));
		return result;
	}
}









