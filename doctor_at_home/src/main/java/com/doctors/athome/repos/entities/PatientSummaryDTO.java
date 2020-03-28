package com.doctors.athome.repos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clinicians")
public class PatientSummaryDTO {
	@Id
	private long patientID;
	
	private String name;
	
	private HealthReportDTO lastReport;
	
	private String MLTriage;
	
	private boolean treated;

	public PatientSummaryDTO(String name, HealthReportDTO lastReport, String mLTriage, boolean treated) {
		super();
		this.name = name;
		this.lastReport = lastReport;
		MLTriage = mLTriage;
		this.treated = treated;
	}

	public long getPatientID() {
		return patientID;
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

	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}
	

}
