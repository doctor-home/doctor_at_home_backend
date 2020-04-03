package com.doctors.athome.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.athome.repos.OrganizationRepository;
import com.doctors.athome.repos.entities.OrganizationDTO;

@RestController
@RequestMapping("/api/dah/v0/organizations")
public class OrganizationController {

private OrganizationRepository orgrepo;
	
	@Autowired
	public OrganizationController(OrganizationRepository orgrepo) {
		this.orgrepo = orgrepo;
	}
	@GetMapping
	public List<OrganizationDTO> findAll(){
		return orgrepo.findAll();
	}
	@PostMapping
	public OrganizationDTO addOrg(@RequestBody OrganizationDTO org){
		return orgrepo.save(org);
	}
}
