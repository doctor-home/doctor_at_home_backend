package com.doctors.athome.repos.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HealthReportDTO {

	
	@Id
	private String healthreportID;
	private Long patientID;
	
	private LocalDateTime timestamp;
	
	public String getHealthreportID() {
		return healthreportID;
	}
	public void setHealthreportID(String healthreportID) {
		this.healthreportID = healthreportID;
	}

	private int heartBeat;
	private float oxygenation;
	private float temperature;
	private int breathingRate;

	
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

	public HealthReportDTO(Long patientID, LocalDateTime timestamp, int fitness, int heartBeat,
			float oxygenation, float temperature, int breathingRate) {
		super();
		this.patientID = patientID;
		this.timestamp = timestamp;
		this.heartBeat = heartBeat;
		this.oxygenation = oxygenation;
		this.temperature = temperature;
		this.breathingRate = breathingRate;
		
	}
	public Long getPatientID() {
		return patientID;
	}
	public void setPatientID(Long patientID) {
		this.patientID = patientID;
	}
}
