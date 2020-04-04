package com.doctors.athome.service;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.doctors.athome.repos.entities.OrganizationDTO;

public class OrganizationServiceImpl implements OrganizationService {

	private final MongoTemplate mongoTemplate;
	
	public OrganizationServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public void save(OrganizationDTO organization) {
		mongoTemplate.save(organization);
	}

	@Override
	public List<OrganizationDTO> findAll() {
		return mongoTemplate.findAll(OrganizationDTO.class);

	}

}
