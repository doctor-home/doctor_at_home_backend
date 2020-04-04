package com.doctors.athome.repos.entities;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("UserDTO")
public class UserDTO{

	@Id
	private String clinicianID;
	
	@NotNull(message= "username cannot be null")
	private String username;
	
	private String password;
	
	private String[] roles;
	
	private boolean isEnabled;
		
	@PersistenceConstructor
	public UserDTO(String clinicianID, String username, String password, String[] roles, @Value("#root.isEnabled?: true") boolean isEnabled) {
		super();
		this.clinicianID = clinicianID;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.isEnabled = isEnabled;
	}

	public UserDTO() {
		super();
	}

	public String getClinicianID() {
		return clinicianID;
	}

	public void setClinicianID(String id) {
		this.clinicianID = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}



}
