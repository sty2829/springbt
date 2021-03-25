package com.springbt.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbt.test.entity.FoodInfo;
import com.springbt.test.respository.FoodInfoRepository;
import com.springbt.test.service.FoodInfoService;


@Service
public class FoodInfoServiceImpl implements FoodInfoService {

	@Autowired
	private FoodInfoRepository foodInfoRepository;
	
	@Override
	public List<FoodInfo> getFoodInfos(FoodInfo foodInfo) {
		if(foodInfo.getFiName() != null) {
			return foodInfoRepository.findByFiNameContaining(foodInfo.getFiName());
		}else if(foodInfo.getFiPrice() != null) {
			return foodInfoRepository.findByFiPriceContaining(String.valueOf(foodInfo.getFiPrice()));
		}else if(foodInfo.getFiType() != null) {
			return foodInfoRepository.findByFiTypeContaining(foodInfo.getFiType());
		}
		
		return foodInfoRepository.findByOrderByFiNumAsc();
	}

	@Override
	public FoodInfo getFoodInfo(Integer fiNum) {
		Optional<FoodInfo> food = foodInfoRepository.findById(fiNum);
		if(food.isEmpty()) {
			return null;
		}
		return food.get();
	}

	@Override
	public FoodInfo saveFoodInfo(FoodInfo foodInfo) {
		return foodInfoRepository.save(foodInfo);
	}

	@Override
	public FoodInfo updateFoodInfo(FoodInfo foodInfo) {
		return foodInfoRepository.save(foodInfo);
	}

	@Override
	public int deleteFoodInfo(Integer fiNum) {
		foodInfoRepository.deleteById(fiNum);
		if(getFoodInfo(fiNum) == null) {
			return 1;
		}
		return 0;
	}

}
