package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.UserDTO;

public interface UserService {

	public UserDTO getUser(String userName);
	public UserDTO getCurrentUser();
	public UserDTO addUser(UserDTO user);
	public List<UserDTO> getUsers();
}
