package com.springbt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbt.test.respository.FileRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SpringbtApplicationTests {
	
	@Autowired
	private FileRepository fileRepo;

	@Test
	void contextLoads() {
		log.info("fiList => {}", fileRepo.findAll());
	}

}
