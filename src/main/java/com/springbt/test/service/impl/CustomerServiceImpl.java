package com.springbt.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbt.test.entity.CustomerInfo;
import com.springbt.test.respository.CustomerInfoRepository;
import com.springbt.test.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerInfoRepository customerInfoRepository;
	
	@Override
	public CustomerInfo login(CustomerInfo customerInfo) {
		CustomerInfo tmpCui = 
				customerInfoRepository
				.findByCuiIdAndCuiPwd(customerInfo.getCuiId(), customerInfo.getCuiPwd());
		log.info("tmpCui =>{}", tmpCui);
		return tmpCui;
	}

	@Override
	public CustomerInfo getCustomerInfoById(Integer cuiNum) {
		return customerInfoRepository.findById(cuiNum).get();
	}

}
