package com.springbt.test.food;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbt.test.entity.FoodInfo;
import com.springbt.test.respository.FoodInfoRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class FoodInfoRepositoryTest {

	@Autowired
	private FoodInfoRepository foodInfoRepository;
	
	@Test
	void test() {
		//삽입
		log.info("foodInfoList => {}", foodInfoRepository.findAll());
		
	}

}
