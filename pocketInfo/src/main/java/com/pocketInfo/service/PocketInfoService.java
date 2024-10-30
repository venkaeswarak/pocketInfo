package com.pocketInfo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pocketInfo.dto.PocketInfoDTO;

@Service
public interface PocketInfoService {
	
	
	//public String savePInfo(PocketInfoDTO inputDTO, MultipartFile file) throws IOException;
	
	public String uploadImage(MultipartFile file) throws IOException;
	
	 public byte[] downloadImage(Long fileId) ;

	public PocketInfoDTO findByPocketInfoId(Long id);

	String savePInfo(PocketInfoDTO inputDTO, List<MultipartFile> files) throws IOException;

}
