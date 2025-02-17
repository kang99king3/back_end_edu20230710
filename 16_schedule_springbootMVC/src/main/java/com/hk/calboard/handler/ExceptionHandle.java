package com.hk.calboard.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@Controller어노테이션이 적용된 곳에서 발생되는 예외를 catch한다.
@ControllerAdvice
public class ExceptionHandle {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		logger.error("Exception발생:{}",e.getMessage());
		model.addAttribute("msg", "오류가 발생하여 확인중입니다.");
		return "thymeleaf/error";
	}
	
}







