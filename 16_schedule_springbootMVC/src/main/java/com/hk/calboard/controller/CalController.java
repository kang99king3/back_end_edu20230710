package com.hk.calboard.controller;

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

import com.hk.calboard.command.InsertCalCommand;
import com.hk.calboard.service.ICalService;

import jakarta.servlet.http.HttpServletRequest;

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
}










