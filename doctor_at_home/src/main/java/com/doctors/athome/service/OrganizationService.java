package com.doctors.athome.service;

import com.doctors.athome.repos.entities.OrganizationDTO;

public interface OrganizationService {
	
	public void save(OrganizationDTO organization);
	public void findAll();

}
