package com.doctors.athome.jobs;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.UserDTO;
import com.doctors.athome.service.UserService;

@Component
public class DefaultDataLoader implements ApplicationRunner {
	
	private UserService userService;
	
	@Value("${spring.security.user.name}")
	private String defaultUser;
	
	@Value("${spring.security.user.password}")
	private String defaultPassword;
	
	@Value("${spring.security.user.roles}")
	private String defaultRole;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public DefaultDataLoader(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userService.addUser(
				new UserDTO(null, defaultUser, 
									passwordEncoder.encode(defaultPassword),
									new ArrayList<String>() {
										private static final long serialVersionUID = 1L;
										{
											add(defaultRole);
										}
									}));
		
	}

}
