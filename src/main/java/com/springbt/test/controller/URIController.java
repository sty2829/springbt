package com.springbt.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbt.test.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class URIController {
	
	private static final List<String> excludeList = new ArrayList<>();
	private static final boolean isDev = true;
	
	@Autowired
	private CustomerService customerService;
	
	static {
		excludeList.add("/views/file/file-info-list");
		excludeList.add("/views/food/food-info-list");
		excludeList.add("/views/user/login");
	}
	

	@GetMapping("/")
	public String hello() {
		return "views/index";
	}
	
	@GetMapping("/views/**")
	public String goView(HttpServletRequest request) {
		String uri = request.getRequestURI();
		HttpSession hs = request.getSession();
		log.info(uri);
		if(hs.getAttribute("customerInfo") == null) {
			if(isDev) {
				hs.setAttribute("customerInfo", customerService.getCustomerInfoById(1));
				return uri;
			}
			if(!excludeList.contains(uri)) {
				return "/views/user/msg";
			}
		}
		return uri;
	}
}
