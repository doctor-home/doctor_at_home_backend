package com.doctors.athome.repos.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.doctors.athome.annotations.CascadeSave;

@Document
public class ClinicianDTO {

	@Id
	private String clinicianID;
	
	private String name;
	
	@DBRef
	@CascadeSave
	private List<OrganizationDTO> organization;
	
	private List<PatientSummaryDTO> patients;

	public ClinicianDTO(String name, List<OrganizationDTO> organization, List<PatientSummaryDTO> patients) {
		super();
		this.name = name;
		this.organization = organization;
		this.patients = patients;
	}

	public String getClinicianID() {
		return clinicianID;
	}

	public void setClinicianID(String clinicianID) {
		this.clinicianID = clinicianID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OrganizationDTO> getOrganization() {
		return organization;
	}

	public void setOrganization(List<OrganizationDTO> organization) {
		this.organization = organization;
	}

	public List<PatientSummaryDTO> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientSummaryDTO> patients) {
		this.patients = patients;
	}
	
	

}
