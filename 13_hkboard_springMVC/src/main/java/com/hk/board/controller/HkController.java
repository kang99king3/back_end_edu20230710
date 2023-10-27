package com.hk.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.board.service.IHkService;

@Controller
public class HkController {
	
	@Autowired
	private IHkService hkService;
	
	@RequestMapping(value="/home.do",method=RequestMethod.GET)
	public String home(Model model) {
		System.out.println("home.do요청");
		
		String msg="Spring 버전 게시판 만들기";
		model.addAttribute("msg", msg);
		
		return "home";
	}
}








