package com.springbt.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbt.test.entity.FoodInfo;
import com.springbt.test.service.FoodInfoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FoodInfoController {

	@Autowired
	private FoodInfoService foodInfoService;
	
	@GetMapping("/food-infos")
	public @ResponseBody List<FoodInfo> getFoodInfos(FoodInfo foodInfo){
		log.info("foodInfo => {}", foodInfo);
		return foodInfoService.getFoodInfos(foodInfo);
	}
	
	@GetMapping("/food-info")
	public @ResponseBody FoodInfo getFoodInfo(@RequestParam Integer fiNum) {
		return foodInfoService.getFoodInfo(fiNum);
	}
	
	@PostMapping("/food-info")
	public @ResponseBody FoodInfo saveFoodInfo(@RequestBody FoodInfo foodInfo) {
		log.info("foodInfo => {}", foodInfo);
		return foodInfoService.saveFoodInfo(foodInfo);
	}
	
	@PostMapping("/food-info-update")
	public @ResponseBody FoodInfo updateFoodInfo(@RequestBody FoodInfo foodInfo) {
		return foodInfoService.updateFoodInfo(foodInfo);
	}
	
	@DeleteMapping("/food-info")
	public @ResponseBody int deleteFoodInfo(@RequestBody FoodInfo foodInfo) {
		return foodInfoService.deleteFoodInfo(foodInfo.getFiNum());
	}
}
