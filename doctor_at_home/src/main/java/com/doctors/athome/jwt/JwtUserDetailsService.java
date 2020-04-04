package com.doctors.athome.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		UserBuilder builder = null;
		if(user == null) {
			throw new UsernameNotFoundException("User - " + username +" - not found" );
		}
		builder = org.springframework.security.core.userdetails.User.withUsername(username);
	    builder.password(user.getPassword());
	    builder.roles(user.getRoles());
	    builder.disabled(!user.isEnabled());
		return builder.build();
	}

}
