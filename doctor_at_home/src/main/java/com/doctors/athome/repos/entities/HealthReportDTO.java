package com.doctors.athome.repos.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("HealthReportDTO")
@CompoundIndex(def="{'healthreportID':1,'timestamp':1}", name="compound_index", unique = true)
public class HealthReportDTO {

	
	@Id
	private String healthreportID;
	
	//Tweak around. Mongodb does not accept null values.
	private LocalDateTime timestamp = LocalDateTime.now();
	
	private String patientID = "";
	
	private int heartBeat;
	private float oxygenation;
	private float temperature;
	private int breathingRate;
	private int ml_triage;
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


	@PersistenceConstructor
	public HealthReportDTO(String healthreportID, LocalDateTime timestamp, String patientID, int heartBeat,
			float oxygenation, float temperature, int breathingRate, int ml_triage) {
		super();
		this.healthreportID = healthreportID;
		this.timestamp = timestamp;
		this.patientID = patientID;
		this.heartBeat = heartBeat;
		this.oxygenation = oxygenation;
		this.temperature = temperature;
		this.breathingRate = breathingRate;
		this.ml_triage = ml_triage;
		
	}
	public int getMl_triage() {
		return ml_triage;
	}
	public void setMl_triage(int ml_triage) {
		this.ml_triage = ml_triage;
	}
	public HealthReportDTO() {
		super();
		
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
}
