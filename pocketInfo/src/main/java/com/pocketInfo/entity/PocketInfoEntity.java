package com.pocketInfo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter

@Table(name = "PocketInfo")
public class PocketInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long pkId;
	
	private String title;
	
	@Column(name = "pocket_category")
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
	
	//@Lob
   // @Column(name = "image_data") 
   // private byte[] imageData; 
	
	
	
}
