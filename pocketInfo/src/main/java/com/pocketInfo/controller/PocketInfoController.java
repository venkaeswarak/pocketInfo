package com.pocketInfo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pocketInfo.dto.PocketInfoDTO;
import com.pocketInfo.service.PocketInfoService;

@RestController
@RequestMapping("/pinfo")
public class PocketInfoController {

	@Autowired
	private PocketInfoService pocketInfoService;

	@PostMapping(path = "/addPInfo", consumes = { "multipart/form-data" })
	public ResponseEntity<?> savePocketInfo(@RequestPart PocketInfoDTO pocketInfo,
			@RequestParam("files") List<MultipartFile> files) {
		String successMessage = "FAILED due some issue!";
		if (pocketInfo.getPkId() == null) {
			try {
				successMessage = pocketInfoService.savePInfo(pocketInfo, files);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(successMessage);

	}

	@GetMapping("/getPInfo")
	public ResponseEntity<?> getPinfo(@RequestParam("id") Long id) {
		PocketInfoDTO pocketInfo = pocketInfoService.findByPocketInfoId(id);
		return ResponseEntity.status(HttpStatus.OK).body(pocketInfo);
	}

	@PostMapping("uploadImage")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		String uploadImage = pocketInfoService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping("/getFile")
	public ResponseEntity<?> downloadImage(@RequestParam("fileId") Long fileId) {
		byte[] imageData = pocketInfoService.downloadImage(fileId);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE))
				.body(imageData);
	}
}
