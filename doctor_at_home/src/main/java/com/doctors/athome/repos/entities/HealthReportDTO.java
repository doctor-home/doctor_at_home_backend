package com.doctors.athome.repos.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HealthReportDTO {

	
	@Id
	private String healthreportID;
	
	private LocalDateTime timestamp;
	
	private String patientID;
	
	private int heartBeat;
	private float oxygenation;
	private float temperature;
	private int breathingRate;
	private int ML_Triage;
	public String getHealthreportID() {
		return healthreportID;
	}
	public void setHealthreportID(String healthreportID) {
		this.healthreportID = healthreportID;
	}


	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	public int getHeartBeat() {
		return heartBeat;
	}
	public void setHeartBeat(int heartBeat) {
		this.heartBeat = heartBeat;
	}
	public float getOxygenation() {
		return oxygenation;
	}
	public void setOxygenation(float oxygenation) {
		this.oxygenation = oxygenation;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public int getBreathingRate() {
		return breathingRate;
	}
	public void setBreathingRate(int breathingRate) {
		this.breathingRate = breathingRate;
	}

	public HealthReportDTO(LocalDateTime timestamp, String patientID, int heartBeat,
			float oxygenation, float temperature, int breathingRate, int ml_triage) {
		super();
		this.timestamp = timestamp;
		this.patientID = patientID;
		this.heartBeat = heartBeat;
		this.oxygenation = oxygenation;
		this.temperature = temperature;
		this.breathingRate = breathingRate;
		this.ML_Triage = ml_triage;
		
	}
	public int getML_Triage() {
		return ML_Triage;
	}
	public void setML_Triage(int mL_Triage) {
		ML_Triage = mL_Triage;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
}
