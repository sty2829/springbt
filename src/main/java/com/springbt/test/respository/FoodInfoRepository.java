package com.springbt.test.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbt.test.entity.FoodInfo;

public interface FoodInfoRepository extends JpaRepository<FoodInfo, Integer> {

	
	List<FoodInfo> findByOrderByFiNumAsc();
	
	List<FoodInfo> findByFiNameContaining(String fiName);
	
	List<FoodInfo> findByFiPriceContaining(String fiPrice);
	
	List<FoodInfo> findByFiTypeContaining(String fiType);
	
	
	List<FoodInfo> findAllByFiNameAndFiPriceAndFiType(String fiName, Integer fiPrice, String fiType);
}
