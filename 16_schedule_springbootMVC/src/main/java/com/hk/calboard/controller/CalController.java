package com.hk.calboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/schedule")
public class CalController {
 
	@GetMapping(value="/calendar")
	public String calendar() {
		
		return "thymeleaf/calboard/calendar";
	}
	
}
