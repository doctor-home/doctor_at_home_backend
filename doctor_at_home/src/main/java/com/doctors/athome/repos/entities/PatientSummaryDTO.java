package com.doctors.athome.repos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("PatientSummaryDTO")
public class PatientSummaryDTO {
	
	@Id
	private String patientID;
	
	private String name;
	
	@DBRef
	private HealthReportDTO lastReport;
	
	

	@PersistenceConstructor
	public PatientSummaryDTO(String patientID, String name) {
		super();
		this.name = name;
		this.patientID = patientID;
	}
	public PatientSummaryDTO() {
		super();
	}

	public String getPatientID() {
		return patientID;
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

	public HealthReportDTO getLastReport() {
		return lastReport;
	}

	public void setLastReport(HealthReportDTO lastReport) {
		this.lastReport = lastReport;
	}

	

}
