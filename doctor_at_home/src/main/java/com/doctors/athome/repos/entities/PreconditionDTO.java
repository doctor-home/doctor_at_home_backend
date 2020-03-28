package com.doctors.athome.repos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="patients")
public class PreconditionDTO {

	@Id
	private Long preconditionID;
	private String name;
	private float probability;
	public PreconditionDTO(String name, float probability) {
		super();
		this.name = name;
		this.probability = probability;
	}
	public Long getPreconditionID() {
		return preconditionID;
	}
	public void setPreconditionID(Long preconditionID) {
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
