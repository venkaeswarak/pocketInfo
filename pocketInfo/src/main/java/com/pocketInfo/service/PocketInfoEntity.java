package com.pocketInfo.service;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PocketInfo")
public class PocketInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long pkId;
	
	private String title;
	
	@Column(name = "pocket_category")
	private String pocketCategory;
	
	private String descreption;
	
	@Lob
    @Column(name = "image_data") 
    private byte[] imageData; 
	
}
