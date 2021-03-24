package com.springbt.test.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbt.test.entity.FileInfo;

public interface FileRepository extends JpaRepository<FileInfo, Long> {

	List<FileInfo> findAllByOrderByFiiNumDesc();
	
	List<FileInfo> findAllByFiiTitleOrderByFiiNumAsc(String fiiTitle);

	List<FileInfo> findAllByFiiContentLikeOrderByFiiNumAsc(String fiiContent);
}
