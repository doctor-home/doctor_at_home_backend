package com.doctors.athome.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dah/v0")
public class BaseController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world, HELLO";
	}
	
	

}
