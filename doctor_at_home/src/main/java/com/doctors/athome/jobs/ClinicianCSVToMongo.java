package com.doctors.athome.jobs;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.doctors.athome.repos.entities.ClinicianDTO;

@EnableBatchProcessing
@Configuration
public class ClinicianCSVToMongo {
	  @Autowired
	  private StepBuilderFactory stepBuilderFactory;

	  @Autowired
	  private MongoTemplate mongoTemplate;

	
	  @Bean
	  public Step step2() {
	    return stepBuilderFactory.get("step2")
	    		.<ClinicianDTO, ClinicianDTO>chunk(10)
	    		.reader(clin_reader())
	    		.writer(clin_writer()).build();
	  }
	  
	  

	  @Bean
	  public FlatFileItemReader<ClinicianDTO> clin_reader() {
	    FlatFileItemReader<ClinicianDTO> reader = new FlatFileItemReader<>();
	    reader.setResource(new ClassPathResource("physicians.csv"));
	    reader.setLinesToSkip(1);
	    reader.setLineMapper(new DefaultLineMapper<ClinicianDTO>() {{
	      setLineTokenizer(new DelimitedLineTokenizer() {});
	      setFieldSetMapper(new ClinicianFromcsvMapper());
	      
	    }});
	    return reader;
	  }
	 
	  @Bean
	  public MongoItemWriter<ClinicianDTO> clin_writer() {
	    MongoItemWriter<ClinicianDTO> writer = new MongoItemWriter<ClinicianDTO>();
	    writer.setTemplate(mongoTemplate);
	    writer.setCollection("ClinicianDTO");
	    return writer;
	  }

}
