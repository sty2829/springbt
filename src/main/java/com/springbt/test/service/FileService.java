package com.springbt.test.service;

import java.util.List;
import java.util.Map;

import com.springbt.test.entity.FileInfo;

public interface FileService {

	FileInfo saveFileInfo(FileInfo fi);
	
	List<FileInfo> getFileInfos(FileInfo fileInfo);
	
	FileInfo getFileInfo(Long fiiNum);

	FileInfo updateFileInfo(FileInfo fi);

	int deleteFileInfo(Long fiiNum);
	
}
