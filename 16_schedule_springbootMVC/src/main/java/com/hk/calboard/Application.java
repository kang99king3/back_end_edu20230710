package com.hk.calboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy //AOP 사용할때 설정해야 함
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	 

}
