package com.springbt.test.food;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbt.test.entity.FoodInfo;
import com.springbt.test.service.FoodInfoService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class FoodInfoServiceTest {

	@Autowired
	private FoodInfoService foodInfoService;
	
	@Test
	void test() {
		//save
		FoodInfo foodInfo = new FoodInfo();
		
		foodInfo.setFiName("제육볶음");
		foodInfo.setFiPrice(10000);
		foodInfo.setFiType("한식");
		foodInfo.setFiDesc("오늘점심에먹음");
//		log.info("foodInfo save => {}", foodInfoService.saveFoodInfo(foodInfo));
		
		//List
		log.info("foodInfoList => {}", foodInfoService.getFoodInfos(foodInfo));
		
		//단일조회
		log.info("foodInfo => {}", foodInfoService.getFoodInfo(1));
		
		//update
//		foodInfo.setFiNum(5);
//		log.info("foodInfo Update => {}", foodInfoService.updateFoodInfo(foodInfo));
		
		log.info("foodInfo Delete => {}", foodInfoService.deleteFoodInfo(5));
	
	}

}
