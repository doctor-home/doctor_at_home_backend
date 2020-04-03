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

import com.doctors.athome.repos.entities.OrganizationDTO;

@EnableBatchProcessing
@Configuration
public class OrganizationcsvJob {
	
	  @Autowired
	  private StepBuilderFactory stepBuilderFactory;

	  @Autowired
	  private MongoTemplate mongoTemplate;

	  @Bean
	  public Step step1() {
	    return stepBuilderFactory.get("step1").<OrganizationDTO, OrganizationDTO>chunk(10)
	    		.reader(org_reader())
	    		.writer(org_writer()).build();
	  }

	  @Bean
	  public FlatFileItemReader<OrganizationDTO> org_reader() {
	    FlatFileItemReader<OrganizationDTO> reader = new FlatFileItemReader<>();
	    reader.setResource(new ClassPathResource("/testdata/centers.csv"));
	    reader.setLinesToSkip(1);
	    reader.setLineMapper(new DefaultLineMapper<OrganizationDTO>() {{
	      setLineTokenizer(new DelimitedLineTokenizer() {});
	      setFieldSetMapper(new CenterscsvMapper());
	      
	    }});
	    return reader;
	  }

	  @Bean
	  public MongoItemWriter<OrganizationDTO> org_writer() {
	    MongoItemWriter<OrganizationDTO> writer = new MongoItemWriter<OrganizationDTO>();
	    writer.setTemplate(mongoTemplate);
	    writer.setCollection("OrganizationDTO");
	    return writer;
	  }

}
