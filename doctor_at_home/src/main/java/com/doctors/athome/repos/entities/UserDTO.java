package com.doctors.athome.repos.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document("UserDTO")
public class UserDTO implements UserDetails{
	@Transient
	private static final long serialVersionUID = 303773252675240862L;

	@Id
	private String clinicianID;
	
	private String username;
	
	private String password;
	
	private List<String> roles;
	
	private boolean isEnabled;
	
	private boolean isCredentialsNonExpired;
	
	private boolean isAccountNonLocked;
	
	private boolean isAccountNonExpired;
	
	@PersistenceConstructor
	public UserDTO(String clinicianID, String username, String password, List<String> roles, @Value("#root.isEnabled?: true") boolean isEnabled,
			@Value("#root.isCredentialsNonExpired?: true") boolean isCredentialsNonExpired, @Value("#root.isAccountNonLocked?: true") boolean isAccountNonLocked, 
			@Value("#root.isAccountNonExpired?: true") boolean isAccountNonExpired) {
		super();
		this.clinicianID = clinicianID;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.isEnabled = isEnabled;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public UserDTO() {
		super();
	}

	public String getClinicianId() {
		return clinicianID;
	}

	public void setClinicianId(String id) {
		this.clinicianID = id;
	}


	@Override
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> grantedRoles = new ArrayList<SimpleGrantedAuthority>();
		for(String role : roles) {
			grantedRoles.add(new SimpleGrantedAuthority(role));
		}
		return grantedRoles;
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}
	


}
