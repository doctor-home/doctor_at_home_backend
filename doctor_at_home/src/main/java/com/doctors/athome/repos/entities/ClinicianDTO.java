package com.doctors.athome.repos.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clinicians")
public class ClinicianDTO {

	@Transient
	public static final String SEQUENCE_NAME = "clinicians_sequence";
	
	@Id
	private long clinicianID;
	
	private String name;
	
	private List<OrganizationDTO> organization;
	
	private List<PatientSummaryDTO> patients;

	public ClinicianDTO(String name, List<OrganizationDTO> organization, List<PatientSummaryDTO> patients) {
		super();
		this.name = name;
		this.organization = organization;
		this.patients = patients;
	}

	public long getClinicianID() {
		return clinicianID;
	}

	public void setClinicianID(long clinicianID) {
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
