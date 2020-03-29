package com.doctors.athome.repos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrganizationDTO {

	@Id
	private String organizationID;
	
	private String name;

	@PersistenceConstructor
	public OrganizationDTO(String name) {
		super();
		this.name = name;
	}
	
	public String getOrganizationID() {
		return organizationID;
	}

	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
