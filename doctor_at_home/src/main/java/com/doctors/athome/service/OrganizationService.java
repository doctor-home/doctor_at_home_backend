package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.OrganizationDTO;

public interface OrganizationService {
	
	public void save(OrganizationDTO organization);
	public List<OrganizationDTO> findAll();

}
