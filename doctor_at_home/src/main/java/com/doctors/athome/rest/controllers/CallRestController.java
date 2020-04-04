package com.doctors.athome.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.athome.repos.entities.CallDTO;
import com.doctors.athome.service.CallService;

@RestController
@RequestMapping("/api/dah")
public class CallRestController {

	private final CallService callservice;
	
	@Autowired
	public CallRestController(CallService callservice) {
		this.callservice = callservice;
	}

	@PostMapping("/call/{patientID}")
	public String callTestPatient(@PathVariable String patientID) {
		CallDTO call = callservice.callPatient(patientID);
		String response = null;
		if(call == null ) response = "Couldn't place call";
		else response = "Call successfuly placed";
		return response;
	}



}
