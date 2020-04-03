package com.doctors.athome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.doctors.athome.config.AuthenticationFacade;
import com.doctors.athome.repos.entities.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	private final MongoTemplate mongoTemplate;
	
	private final AuthenticationFacade auth;
	
	@Autowired
	public UserServiceImpl(MongoTemplate mongoTemplate, AuthenticationFacade auth) {
		this.mongoTemplate = mongoTemplate;
		this.auth = auth;
	}

	@Override
	public UserDTO getUser(String userName) {
		UserDTO user = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		user = mongoTemplate.findOne(query, UserDTO.class);
		return user;
	}

	@Override
	public UserDTO getCurrentUser() {
		String username = auth.getCurrentUsername();
		UserDTO user = null;
		if(username != null)
			user = getUser(username);
		return user;
	}

	@Override
	public UserDTO addUser(UserDTO user) {
		return mongoTemplate.save(user);
	}
	
	
}
