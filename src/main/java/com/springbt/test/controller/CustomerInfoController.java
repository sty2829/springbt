package com.springbt.test.controller;

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
	public @ResponseBody CustomerInfo login(@RequestBody CustomerInfo customerInfo) {
		return customerService.login(customerInfo);
	}
}
