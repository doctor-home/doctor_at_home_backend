package com.doctors.athome.repos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="organization")
public class OrganizationDTO {

	@Id
	private Long organizationID;
	
	private String name;

	public OrganizationDTO(String name) {
		super();
		this.name = name;
	}

	public Long getOrganizationID() {
		return organizationID;
	}

	public void setOrganizationID(Long organizationID) {
		this.organizationID = organizationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
