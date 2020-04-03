package com.doctors.athome.service;

import com.doctors.athome.repos.entities.UserDTO;

public interface UserService {

	public UserDTO getUser(String userName);
	public UserDTO getCurrentUser();
	public UserDTO addUser(UserDTO user);
}
