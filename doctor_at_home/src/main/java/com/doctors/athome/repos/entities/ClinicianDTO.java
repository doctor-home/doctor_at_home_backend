package com.doctors.athome.repos.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document("ClinicianDTO")
public class ClinicianDTO {

	@Id
	private String clinicianID;
	
	private String name;
	
	private String userName;
	
	private String password;
	
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<OrganizationDTO> organization;
	
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<PatientSummaryDTO> patients;

	@PersistenceConstructor
	public ClinicianDTO(String clinicianID, String name, List<OrganizationDTO> organization, List<PatientSummaryDTO> patients) {
		super();
		this.clinicianID = clinicianID;
		this.name = name;
		this.organization = organization;
		this.patients = patients;
	}
	
	public ClinicianDTO() {
		super();
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
			organization = new ArrayList<OrganizationDTO>();
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
			patients = new ArrayList<PatientSummaryDTO>();
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
