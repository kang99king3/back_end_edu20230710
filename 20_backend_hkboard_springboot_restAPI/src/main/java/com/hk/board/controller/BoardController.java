package com.hk.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hk.board.dtos.HkDto;
import com.hk.board.service.HkService;

@RestController
@RequestMapping("/api/board")
public class BoardController {

	@Autowired
	private HkService boardService;
	
	//글목록 요청
//	@ResponseBody  : @RestController를 정의하면 작성할 필요 없음
	@GetMapping("/boardlist")
	public Map<String, List<HkDto>> boardList() {
		System.out.println("글목록 요청");
		//글목록 데이터 list객체를 Map에 저장한다. --> json{"list":list}
		//--> json :   {"list":[dto,dto,dto...]} 서버쪽에서 전달할때 형태
		//    JS   :   data["list"]--> [dto,dto...] 화면쪽에서 받을 형태
		Map<String, List<HkDto>> map=new HashMap<>();
		map.put("list", boardService.getAllList());
		
		return map;
	}
}











