package com.springbt.test.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springbt.test.entity.FileInfo;
import com.springbt.test.respository.FileRepository;
import com.springbt.test.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

	private final String ROOT = "C:\\Users\\Administrator\\git\\springbt\\src\\main\\webapp\\resources\\";
	
	@Autowired
	private FileRepository fileRepo;
	
	@Override
	public FileInfo saveFileInfo(FileInfo fi) {
		MultipartFile mf = fi.getFiiFile();
		log.info("fileName => {}", mf.getOriginalFilename());
		int idx = mf.getOriginalFilename().lastIndexOf(".");
		String extName = mf.getOriginalFilename().substring(idx);
		String filePath = System.nanoTime() + extName;
		log.info("filePath => {}", filePath);
		fi.setFiiFileName(mf.getOriginalFilename());
		fi.setFiiFilePath(filePath);
		File file = new File(ROOT + filePath);
		try {
			mf.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileRepo.save(fi);
	}

	@Override
	public List<FileInfo> getFileInfos(FileInfo fileInfo) {
		if(fileInfo.getFiiTitle() != null) {
			return fileRepo.findAllByFiiTitleOrderByFiiNumAsc(fileInfo.getFiiTitle());
		}
		if(fileInfo.getFiiContent() != null) {
			return fileRepo.findAllByFiiContentLikeOrderByFiiNumAsc("%" + fileInfo.getFiiContent() + "%");
		}
		List<FileInfo> fileInfoList = fileRepo.findAllByOrderByFiiNumDesc();
		return fileInfoList;
	}

	@Override
	public FileInfo getFileInfo(Long fiiNum) {
		Optional<FileInfo> opfi = fileRepo.findById(fiiNum);
		if(opfi.isEmpty()) return null;
		return opfi.get();
	}

	@Override
	public FileInfo updateFileInfo(FileInfo fi) {
		MultipartFile mf = fi.getFiiFile();
		int idx = mf.getOriginalFilename().lastIndexOf(".");
		String filePath = System.nanoTime() + mf.getOriginalFilename().substring(idx);
		fi.setFiiFileName(mf.getOriginalFilename());
		fi.setFiiFilePath(filePath);
		File file = new File(ROOT + filePath);
		try {
			mf.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileRepo.save(fi);
	}

	@Override
	public int deleteFileInfo(Long fiiNum) {
		fileRepo.deleteById(fiiNum);
		if(getFileInfo(fiiNum) == null) {
			return 1;
		}
		return 0;
	}

}
