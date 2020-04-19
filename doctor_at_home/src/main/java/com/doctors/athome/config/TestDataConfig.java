package com.doctors.athome.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.doctors.athome.jobs.CliniciancsvJob;
import com.doctors.athome.jobs.HealthreportscsvJob;
import com.doctors.athome.jobs.OrganizationcsvJob;
import com.doctors.athome.jobs.PatientcsvJob;
import com.doctors.athome.jobs.UserDocJob;

/**
 * DB load job that will load the demo CSVs into the MongoDB. 
 * Activate the "demo" profile and this will run on startup (may take a while, be aware of container startup timeout on Azure) 
 */
@Profile(value = {"demo"})
@EnableBatchProcessing
@Configuration
public class TestDataConfig {
	@Autowired
	 private JobBuilderFactory jobBuilderFactory;	
	 @Autowired
	 private OrganizationcsvJob organizationJob;
	 @Autowired
	 private CliniciancsvJob clinicianJob;
	 @Autowired
	 private UserDocJob userJob;
	 @Autowired
	 private HealthreportscsvJob healthMsJob;
	 @Autowired
	 private PatientcsvJob patientJob;
	 
	 @Bean
	 public Job readCSVFile() {
		 return jobBuilderFactory.get("readCSVFile")
	    		.incrementer(new RunIdIncrementer())
	    		.start(organizationJob.step1())
	    		.next(clinicianJob.step2())
	    		.next(userJob.step3())
	    		.next(healthMsJob.step4())
	    		.next(patientJob.step5())
	    		.build();
	  }


}
