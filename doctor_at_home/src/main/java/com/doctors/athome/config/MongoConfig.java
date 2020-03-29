package com.doctors.athome.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.doctors.athome.repos.entities.events.CascadeSaveMongoEventListener;

@Configuration
@EnableMongoRepositories(basePackages = "com.doctors.athome")
public class MongoConfig{

	@Bean
	public CascadeSaveMongoEventListener cascadeSaveMongoEventListener() {
		return new CascadeSaveMongoEventListener();
	}
	
   
	
}
