package com.pocketInfo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PocketInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketInfoApplication.class, args);
	}
	 @Bean
	    public ModelMapper getModelMapper() {
	        return new ModelMapper();
	    }
}
