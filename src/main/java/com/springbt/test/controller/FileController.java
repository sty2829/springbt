package com.springbt.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbt.test.entity.FileInfo;
import com.springbt.test.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileController {

	@Autowired
	private FileService fileService;
	
	@PostMapping("/file-info")
	public @ResponseBody Long upload(@ModelAttribute FileInfo fi) {
		log.info("fi => {}", fi);
		fi = fileService.saveFileInfo(fi);
		return fi.getFiiNum();
	}
	
	@PostMapping("/file-info/update")
	public @ResponseBody Long update(@ModelAttribute FileInfo fi) {
		fi = fileService.updateFileInfo(fi);
		return fi.getFiiNum();
	}
	
	@GetMapping("/file-infos")
	public @ResponseBody List<FileInfo> getFileInfos(@ModelAttribute FileInfo fileInfo){
		log.info("fileInfo => {}", fileInfo);
		return fileService.getFileInfos(fileInfo);
	}
	
	@GetMapping("/file-info")
	public @ResponseBody FileInfo getFileInfo(@RequestParam Long fiiNum){
		return fileService.getFileInfo(fiiNum);
	}
		
	@DeleteMapping("file-info")
	public @ResponseBody int deleteFileInfo(@RequestParam Long fiiNum) {
		return fileService.deleteFileInfo(fiiNum);
	}
}
