package com.pocketInfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocketInfoController {
	
	//http://localhost:2024/msg?name=VENKAT
	@RequestMapping(path = "/msg")
	public String getMsg(@RequestParam("name")String name) {
		return "Hello World.. "+name;
		
	}
	

}
