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

import com.doctors.athome.repos.entities.PatientDTO;

@EnableBatchProcessing
@Configuration
public class PatientcsvToMongo {
	
	  @Autowired
	  private StepBuilderFactory stepBuilderFactory;

	  @Autowired
	  private MongoTemplate mongoTemplate;

	  @Bean
	  public Step step4() {
	    return stepBuilderFactory.get("step1").<PatientDTO, PatientDTO>chunk(10).reader(reader())
	        .writer(writer()).build();
	  }

	  @Bean
	  public FlatFileItemReader<PatientDTO> reader() {
	    FlatFileItemReader<PatientDTO> reader = new FlatFileItemReader<>();
	    reader.setResource(new ClassPathResource("patients_list.csv"));
	    reader.setLinesToSkip(1);
	    reader.setLineMapper(new DefaultLineMapper<PatientDTO>() {{
	      setLineTokenizer(new DelimitedLineTokenizer() {});
	      setFieldSetMapper(new PatientFromcsvMapper());
	      
	    }});
	    return reader;
	  }

	  @Bean
	  public MongoItemWriter<PatientDTO> writer() {
	    MongoItemWriter<PatientDTO> writer = new MongoItemWriter<PatientDTO>();
	    writer.setTemplate(mongoTemplate);
	    writer.setCollection("PatientDTO");
	    return writer;
	  }

}
