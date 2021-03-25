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
		FoodInfo foodInfo = new FoodInfo();
//		foodInfo.setFiName("제육볶음");
//		foodInfo.setFiPrice(7000);
//		foodInfo.setFiType("한식");
//		foodInfo.setFiDesc("오늘점심에먹음");
//		
//		log.info("food Insert => {}", foodInfoRepository.save(foodInfo));
//		
		
		//전체 조회
		log.info("foodList => {}", foodInfoRepository.findAll());
		//id 조회
		log.info("food => {}", foodInfoRepository.findById(2));
		
		
		
		//수정
		foodInfo.setFiNum(2);
		
		
//		log.info("food => {}", foodInfoRepository.save(foodInfo));
		
	
		//삭제
		
		foodInfoRepository.delete(foodInfo);
		log.info("food =>{}", foodInfoRepository.findById(2));
		
	}

}
