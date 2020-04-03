package com.doctors.athome.repos.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Document("UserDTO")
public class UserDTO {
	@Id
	private String clinicianID;
	
	private String userName;
	
	private String password;
	
	private List<String> roles;
	
	@PersistenceConstructor
	public UserDTO(String clinicianID, String userName, String password, List<String> roles) {
		super();
		this.clinicianID = clinicianID;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public String getClinicianId() {
		return clinicianID;
	}

	public void setClinicianId(String id) {
		this.clinicianID = id;
	}

	public UserDTO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public List<SimpleGrantedAuthority> getGrantedAuthorities(){
		List<SimpleGrantedAuthority> grantedRoles = new ArrayList<SimpleGrantedAuthority>();
		for(String role : roles) {
			grantedRoles.add(new SimpleGrantedAuthority(role));
		}
		return grantedRoles;
	}


}
