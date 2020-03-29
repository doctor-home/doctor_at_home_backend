package com.doctors.athome.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class MasterProcess {
	@Autowired
	  private JobBuilderFactory jobBuilderFactory;
	
	 @Autowired
	  private OrganizationcsvToMongo organizationJob;
	 @Autowired
	  private ClinicianCSVToMongo clinicianJob;
	 @Autowired
	  private MeasurementcsvToMongo healthMsJob;
	 
	 @Bean
	  public Job readCSVFile() {
	    return jobBuilderFactory.get("readCSVFile")
	    		.incrementer(new RunIdIncrementer())
	    		.start(organizationJob.step1())
	    		.next(clinicianJob.step2())
	    		.next(healthMsJob.step3())
	    		.build();
	  }


}
