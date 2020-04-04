package com.doctors.athome.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.athome.repos.entities.UserDTO;
import com.doctors.athome.service.UserService;

@RestController
@RequestMapping("/api/dah/v0/users")
public class UserController {

	private final UserService userservice;
	
	@Autowired
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}
	
	@GetMapping
	public List<UserDTO> getUsers() {
		return userservice.getUsers();
	}
	
	@PostMapping
	public UserDTO addUser(@RequestBody UserDTO user) {
		return userservice.addUser(user);
	}
	
	@PutMapping
	public UserDTO updateUser(@RequestBody UserDTO user) {
		if(user.getClinicianId() == null) {
			throw new RuntimeException("Cannot update user data, clinicianID is missing");
		}
		return userservice.addUser(user);
	}
	
	@GetMapping("/current")
	public UserDTO getCurrentUser() {
		return userservice.getCurrentUser();
	}
	
}
