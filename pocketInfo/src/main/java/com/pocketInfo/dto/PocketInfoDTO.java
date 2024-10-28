package com.pocketInfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
	
}
