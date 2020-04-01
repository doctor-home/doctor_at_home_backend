package com.doctors.athome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EntityScan("com.doctors.athome.repos.entities")
@EnableMongoRepositories("com.doctors.athome.repos.entities.repositories")
@SpringBootApplication(scanBasePackages = "com.doctors.athome", exclude = {DataSourceAutoConfiguration.class,EmbeddedMongoAutoConfiguration.class})
public class DoctorAtHomeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DoctorAtHomeApplication.class, args);
	}
	
	

}
