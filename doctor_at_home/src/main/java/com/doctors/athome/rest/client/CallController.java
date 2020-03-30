package com.doctors.athome.rest.client;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.athome.repos.entities.Call;

@RestController
@RequestMapping("/outbound-call")
public class CallController {
	
	@PostMapping("out-boundcalls")
	public Call getPatientInfo() {
		return null;
	}

}
