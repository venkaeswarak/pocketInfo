package com.pocketInfo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Setter
@Getter
@Table(name = "PocketInfo")
public class PocketInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long pkId;
	
	private String title;
	
	@Column(name = "pocket_category")
	private String pocketCategory;
	
	private String descreption;

	
	@OneToMany(mappedBy = "pocketInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

	 
	
	//@Lob
   // @Column(name = "image_data") 
   // private byte[] imageData; 
	
	
}
