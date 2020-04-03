package com.doctors.athome.jwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.UserDTO;
import com.doctors.athome.service.UserService;

@Component
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user = userService.getUser(username);
		if(user == null) {
			throw new UsernameNotFoundException("User - " + username +" - not found" );
		}
		List<SimpleGrantedAuthority> authorities = user.getGrantedAuthorities();
		return new User(user.getUserName(), user.getPassword(), authorities);
	}

}
