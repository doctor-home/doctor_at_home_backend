package com.doctors.athome.repos.entities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.doctors.athome.annotations.CascadeSave;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDTO {
	
	@Id
	private String patientID;
	
	private String name;
	
	private String phone;
	
	private String city;
	
	private String clinicianID;
	
	private String language;
	
	private int daysUnderInspection;
	
	private int fitness;
	
	private boolean smoker;
	
	private String preconditions;
	
	private boolean under_observation;
	
	
	@DBRef
	private PatientSummaryDTO summary;
	
	public String getPreconditions() {
		return preconditions;
	}


	public void setPreconditions(String preconditions) {
		this.preconditions = preconditions;
	}


	public int getDaysUnderInspection() {
		return daysUnderInspection;
	}


	public void setDaysUnderInspection(int daysUnderInspection) {
		this.daysUnderInspection = daysUnderInspection;
	}


	public String getPatientID() {
		return patientID;
	}
	

	public PatientDTO() {
		super();
	}


	@PersistenceConstructor
	public PatientDTO(String name, String phone, String city, String language, @Value("#root.daysUnderInspection?: 0")int daysUnderInspection, int fitness,
			@Value("#root.smoker?: false")boolean smoker, @Value("#root.smoker?: false")boolean under_observation, String clinicianID, String preconditions, PatientSummaryDTO summary) {
		super();
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.language = language;
		this.daysUnderInspection = daysUnderInspection;
		this.under_observation = under_observation;
		this.fitness = fitness;
		this.smoker = smoker;
		this.preconditions = preconditions;
		this.summary = summary;
		this.clinicianID = clinicianID;
		this.summary.setName(name);
	}


	public void setPatientID(String patientID) {
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

	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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


	public PatientSummaryDTO getPatientSummary() {
		return summary;
	}


	public void setPatientSummary(PatientSummaryDTO patientSummary) {
		this.summary = patientSummary;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getClinicianID() {
		return clinicianID;
	}


	public void setClinicianID(String clinicianID) {
		this.clinicianID = clinicianID;
	}


	public boolean isUnder_observation() {
		return under_observation;
	}


	public void setUnder_observation(boolean under_observation) {
		this.under_observation = under_observation;
	}



}
