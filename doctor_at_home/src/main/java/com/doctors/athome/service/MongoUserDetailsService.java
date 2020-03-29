package com.doctors.athome.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.ClinicianDTO;

@Component
public class MongoUserDetailsService implements UserDetailsService{

	@Autowired
	private ClinicianService clinicianService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ClinicianDTO clinician = clinicianService.findByUsername(username);
		if(clinician == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		
		return new User(clinician.getUserName(), clinician.getPassword(), authorities);
	}

}
