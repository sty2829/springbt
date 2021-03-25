package com.springbt.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbt.test.entity.CustomerInfo;
import com.springbt.test.service.CustomerService;

@Controller
public class CustomerInfoController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/login")
	public @ResponseBody CustomerInfo login(@RequestBody CustomerInfo customerInfo, HttpServletRequest request) {
		CustomerInfo cui = customerService.login(customerInfo);
		if(cui!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("customerInfo", cui);
		}
		return cui;
	}
	
	@PostMapping("/logout")
	public @ResponseBody boolean logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return true;
	}
}
