package com.doctors.athome.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.athome.service.CallService;

@RestController
@RequestMapping("/api/dah/v0")
public class BaseController {
	
	private CallService callservice;
	
	@Autowired
	public BaseController(CallService callservice) {
		this.callservice = callservice;
	}
	
	@GetMapping("/call/{patientID}")
	public String callTestPatient(@PathVariable String patientID) {
		callservice.callPatient(patientID);
		return "Call successfuly placed";
	}
	
	

}
