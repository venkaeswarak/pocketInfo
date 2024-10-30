package com.pocketInfo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pocketInfo.ImageUtils;
import com.pocketInfo.dto.PocketInfoDTO;
import com.pocketInfo.entity.Image;
import com.pocketInfo.entity.PocketInfoEntity;
import com.pocketInfo.repository.ImageRepository;

@Service
public class PocketInforServiceImpl implements PocketInfoService {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	PocketInfoRepository pocketInfoRepository;

	@Autowired
	ModelMapper model;

	@Override
	public String savePInfo(PocketInfoDTO inputDTO,List<MultipartFile> files) throws IOException {

		ModelMapper model = new ModelMapper();
		PocketInfoEntity pocketInfoEntity = model.map(inputDTO, PocketInfoEntity.class);
		List<Image> images = new ArrayList<>();
		files.stream().forEach(file->{
			Image imageToSave = null;
			try {
				imageToSave = Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
						.imageData(ImageUtils.compressImage(file.getBytes())).pocketInfo(pocketInfoEntity).build();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			images.add(imageToSave);
		});
		
		pocketInfoEntity.setImages(images);
		pocketInfoRepository.save(pocketInfoEntity);
		return "PocketInfo saved successfully.";
	}

	@Override
	public String uploadImage(MultipartFile imageFile) throws IOException {
		var imageToSave = Image.builder().name(imageFile.getOriginalFilename()).type(imageFile.getContentType())
				.imageData(ImageUtils.compressImage(imageFile.getBytes())).build();
		imageRepository.save(imageToSave);
		return "file uploaded successfully : " + imageFile.getOriginalFilename();
	}

	@Override
	public byte[] downloadImage(Long fileId) {
		Optional<Image> dbImage = imageRepository.findById(fileId);

		return dbImage.map(image -> {
			try {
				return ImageUtils.decompressImage(image.getImageData());
			} catch (DataFormatException | IOException exception) {
				throw new ContextedRuntimeException("Error downloading an image", exception)
						.addContextValue("Image ID", image.getImgId()).addContextValue("Image id", fileId);
			}
		}).orElse(null);
	}

	@Override
	public PocketInfoDTO findByPocketInfoId(Long id) {
		PocketInfoEntity pInfo = pocketInfoRepository.findById(id).orElse(new PocketInfoEntity());
		PocketInfoDTO pocketInfo = model.map(pInfo, PocketInfoDTO.class);
		return pocketInfo;
	}

}
