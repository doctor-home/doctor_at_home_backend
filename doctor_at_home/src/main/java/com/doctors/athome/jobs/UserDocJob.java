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

import com.doctors.athome.repos.entities.UserDTO;

@EnableBatchProcessing
@Configuration
public class UserDocJob {
	
	@Autowired
	  private StepBuilderFactory stepBuilderFactory;

	  @Autowired
	  private MongoTemplate mongoTemplate;

	
	  @Bean
	  public Step step3() {
	    return stepBuilderFactory.get("step3")
	    		.<UserDTO, UserDTO>chunk(10)
	    		.reader(user_reader())
	    		.writer(user_writer()).build();
	  }
	  
	  

	  @Bean
	  public FlatFileItemReader<UserDTO> user_reader() {
	    FlatFileItemReader<UserDTO> reader = new FlatFileItemReader<>();
	    reader.setResource(new ClassPathResource("/testdata/physicians.csv"));
	    reader.setLinesToSkip(1);
	    reader.setLineMapper(new DefaultLineMapper<UserDTO>() {{
	      setLineTokenizer(new DelimitedLineTokenizer() {});
	      setFieldSetMapper(new UserFromCliniciancsvMapper());
	      
	    }});
	    return reader;
	  }
	 
	  @Bean
	  public MongoItemWriter<UserDTO> user_writer() {
	    MongoItemWriter<UserDTO> writer = new MongoItemWriter<UserDTO>();
	    writer.setTemplate(mongoTemplate);
	    writer.setCollection("UserDTO");
	    return writer;
	  }


}
