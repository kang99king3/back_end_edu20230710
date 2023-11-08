package com.hk.calboard.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.calboard.command.InsertCalCommand;
import com.hk.calboard.dtos.CalDto;
import com.hk.calboard.service.ICalService;
import com.hk.calboard.utils.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/schedule")
public class CalController {
	//log를 원하는 위치에 설정하여 디버깅 하기
	private static final Logger logger=LoggerFactory.getLogger(CalController.class);
	
	@Autowired
	private ICalService calService;
	
	@GetMapping(value="/calendar")
	public String calendar(Model model, HttpServletRequest request) {
		logger.info("달력보기"); 
		Map<String, Integer>map=calService.makeCalendar(request);
		model.addAttribute("calMap", map);
		return "thymeleaf/calboard/calendar";
	}
	
	@GetMapping(value = "/addCalBoardForm")
	public String addCalBoardForm(Model model, InsertCalCommand insertCalCommand) {
		logger.info("일정추가폼이동");
		System.out.println(insertCalCommand);
		//addCalBoardfForm 페이지에서 유효값 처리를 위해 insertCalCommand 받고 있기때문에
		model.addAttribute("insertCalCommand", insertCalCommand);
		return "thymeleaf/calboard/addCalBoardForm";
	}
	
	@PostMapping(value = "/addCalBoard")
	public String addCalBoard(@Validated InsertCalCommand insertCalCommand,
							  BindingResult result) {
		logger.info("일정추가하기");
		System.out.println(insertCalCommand);
		if(result.hasErrors()) {
			System.out.println("글을 모두 입력해야 함");
			return "thymeleaf/calboard/addCalBoardForm";
		}
		
		calService.insertCalBoard(insertCalCommand);
		
		return "redirect:/schedule/calendar";
	}
	
	@GetMapping(value = "/calBoardList")
	public String calBoardList(@RequestParam Map<String, String>map
							, HttpServletRequest request
							, Model model) {
		logger.info("일정목록보기");
//		HttpSession session=request.getSession();
//		String id=session.getAttribute("id");
		String id="kbj";//임시로 id 저장
		
		
		
		
		//달력에서 전달받은 파라미터 year, month, date를 8자리로 만든다.
		String yyyyMMdd=map.get("year")
				       +Util.isTwo(map.get("month"))
				       +Util.isTwo(map.get("date"));
		List<CalDto> list= calService.calBoardList(id, yyyyMMdd);
		model.addAttribute("list", list);
		
		return "thymeleaf/calboard/calBoardList";
	}
}










