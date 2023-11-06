package com.hk.calboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalController {
 
	@GetMapping(value = "/")
	public String home() {
		System.out.println("home");
		return "thymeleaf/calboard/home";
	}
}
