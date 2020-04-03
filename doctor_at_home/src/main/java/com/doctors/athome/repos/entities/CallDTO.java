package com.doctors.athome.repos.entities;

import java.net.URL;


public class CallDTO {
	
	private String from;
	private String to;
	private String patientID;
	private URL webhook;
	public CallDTO(String from, String to, String patientID, URL webhook) {
		super();
		this.from = from;
		this.to = to;
		this.patientID = patientID;
		this.webhook = webhook;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public URL getWebhook() {
		return webhook;
	}
	public void setWebhook(URL webhook) {
		this.webhook = webhook;
	}
	

}
