package com.doctors.athome.repos.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.doctors.athome.annotations.CascadeSave;

@Document
public class ClinicianDTO {

	@Id
	private String clinicianID;
	
	private String name;
	
	private String userName;
	
	private String password;
	
	@DBRef
	@CascadeSave
	private List<OrganizationDTO> organization;
	
	private List<PatientSummaryDTO> patients;

	@PersistenceConstructor
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
	public void addOrganization(OrganizationDTO org) {
		if(organization == null) {
			organization = new ArrayList<>();
		}
		organization.add(org);
	}

	public List<PatientSummaryDTO> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientSummaryDTO> patients) {
		this.patients = patients;
	}
	public void addPatient(PatientSummaryDTO patient) {
		if(patients == null) {
			patients = new ArrayList<>();
		}
		patients.add(patient);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	

}
