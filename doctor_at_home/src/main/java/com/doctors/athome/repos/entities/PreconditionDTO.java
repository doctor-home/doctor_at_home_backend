package com.doctors.athome.repos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PreconditionDTO {

	@Id
	private String preconditionID;
	private String name;
	private float probability;
	
	@PersistenceConstructor
	public PreconditionDTO(String name, float probability) {
		super();
		this.name = name;
		this.probability = probability;
	}
	public String getPreconditionID() {
		return preconditionID;
	}
	public void setPreconditionID(String preconditionID) {
		this.preconditionID = preconditionID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getProbability() {
		return probability;
	}
	public void setProbability(float probability) {
		this.probability = probability;
	}
	
}
