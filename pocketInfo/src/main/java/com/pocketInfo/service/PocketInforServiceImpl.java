package com.pocketInfo.service;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.pocketInfo.ImageUtils;
import com.pocketInfo.entity.Image;
import com.pocketInfo.repository.ImageRepository;

public class PocketInforServiceImpl implements PocketInfoService {
	
	@Autowired
	ImageRepository imageRepository;
	
	 public String uploadImage(MultipartFile imageFile) throws IOException {
		 
	        var imageToSave = Image.builder();
	        imageToSave.setName(imageFile.getOriginalFilename());
	        imageToSave.setType(imageFile.getContentType());
	        imageToSave.setImageData(ImageUtils.compressImage(imageFile.getBytes()));
	                //.build();
	        imageRepository.save(imageToSave);
	        return "file uploaded successfully : " + imageFile.getOriginalFilename();
	    }

	    public byte[] downloadImage(String imageName) {
	        Optional<Image> dbImage = imageRepository.findByName(imageName);

	        return dbImage.map(image -> {
	            try {
	                return ImageUtils.decompressImage(image.getImageData());
	            } catch (DataFormatException | IOException exception) {
	                throw new ContextedRuntimeException("Error downloading an image", exception)
	                        .addContextValue("Image ID",  image.getId())
	                        .addContextValue("Image name", imageName);
	            }
	        }).orElse(null);
	    }

}
