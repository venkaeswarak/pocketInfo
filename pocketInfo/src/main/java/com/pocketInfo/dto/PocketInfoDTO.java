package com.pocketInfo.dto;

import java.util.ArrayList;
import java.util.List;

import com.pocketInfo.service.ImageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Setter
//@Getter
public class PocketInfoDTO {
	private Long pkId;
	
	private String title;
	
	private String pocketCategory;
	
	private String descreption;
	
	private List<ImageDTO> images = new ArrayList<>();

	public Long getPkId() {
		return pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPocketCategory() {
		return pocketCategory;
	}

	public void setPocketCategory(String pocketCategory) {
		this.pocketCategory = pocketCategory;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}
	
	
}
