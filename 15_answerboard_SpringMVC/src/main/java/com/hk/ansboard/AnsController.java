package com.hk.ansboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnsController {

	@GetMapping(value = "/home.do")
	public String home() {
		System.out.println("HOME요청");
		return "home";
	}
}
