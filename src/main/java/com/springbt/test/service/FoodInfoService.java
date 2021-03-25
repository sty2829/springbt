package com.springbt.test.service;

import java.util.List;

import com.springbt.test.entity.FoodInfo;

public interface FoodInfoService {

	List<FoodInfo> getFoodInfos(FoodInfo foodInfo);
	
	FoodInfo getFoodInfo(Integer fiNum);
	
	FoodInfo saveFoodInfo(FoodInfo foodInfo);
	
	FoodInfo updateFoodInfo(FoodInfo foodInfo);
	
	int deleteFoodInfo(Integer fiNum);
}
