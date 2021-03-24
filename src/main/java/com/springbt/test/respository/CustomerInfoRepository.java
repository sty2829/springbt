package com.springbt.test.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbt.test.entity.CustomerInfo;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer> {

	CustomerInfo findByCuiIdAndCuiPwd(String cuiId, String cuiPwd);
}
