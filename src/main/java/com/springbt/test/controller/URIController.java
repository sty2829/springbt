package com.springbt.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URIController {

	@GetMapping("/")
	public String hello() {
		return "views/index";
	}
	
	@GetMapping("/views/**")
	public void goView() {
		
	}
}
