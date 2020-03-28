package com.doctors.athome.repos.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection="patients")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDTO {
	@Transient
	public static final String SEQUENCE_NAME = "patients_sequence";
	
	@Id
	private long patientID;
	
	private String name;
	
	private String phone;
	
	private HealthReportDTO lastReport;
	
	private String MLTriage;
	
	private String language;
	
	private boolean treated;
	
	private List<OrganizationDTO> organization;
	
	private List<PreconditionDTO> preconditions;
	
	private int daysUnderInspection;
	private int fitness;
	private boolean smoker;
	public List<PreconditionDTO> getPreconditions() {
		return preconditions;
	}


	public void setPreconditions(List<PreconditionDTO> preconditions) {
		this.preconditions = preconditions;
	}


	public int getDaysUnderInspection() {
		return daysUnderInspection;
	}


	public void setDaysUnderInspection(int daysUnderInspection) {
		this.daysUnderInspection = daysUnderInspection;
	}


	public long getPatientID() {
		return patientID;
	}
	

	public PatientDTO() {
		super();
	}


	public PatientDTO(String name, String phone, String mLTriage, String language, int fitness, boolean smoker, List<OrganizationDTO> organization, List<PreconditionDTO> preconditions) {
		super();
		this.name = name;
		this.phone = phone;
		MLTriage = mLTriage;
		this.language = language;
		this.organization = organization;
		this.preconditions = preconditions;
		this.smoker = smoker;
		this.fitness = fitness;
	}


	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public HealthReportDTO getLastReport() {
		return lastReport;
	}

	public void setLastReport(HealthReportDTO lastReport) {
		this.lastReport = lastReport;
	}

	public String getMLTriage() {
		return MLTriage;
	}

	public void setMLTriage(String mLTriage) {
		MLTriage = mLTriage;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}

	public List<OrganizationDTO> getOrganization() {
		return organization;
	}

	public void setOrganization(List<OrganizationDTO> organization) {
		this.organization = organization;
	}
	public int getFitness() {
		return fitness;
	}
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	public boolean isSmoker() {
		return smoker;
	}
	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}
	
	

}
