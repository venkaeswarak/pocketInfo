package com.pocketInfo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pocketInfo.dto.PocketInfoDTO;

@Service
public interface PocketInfoService {
	
	
	public String savePInfo(PocketInfoDTO inputDTO);
	
	public String uploadImage(MultipartFile imageFile) throws IOException;
	
	 public byte[] downloadImage(String imageName) ;

	public PocketInfoDTO findById(Long id);

}
