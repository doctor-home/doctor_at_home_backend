package com.doctors.athome.jobs;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.RegexLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.doctors.athome.repos.entities.PatientDTO;

@EnableBatchProcessing
@Configuration
public class PatientcsvJob {
	
	  @Autowired
	  private StepBuilderFactory stepBuilderFactory;

	  @Autowired
	  private MongoTemplate mongoTemplate;

	  @Bean
	  public Step step5() {
	    return stepBuilderFactory.get("step5").<PatientDTO, PatientDTO>chunk(10)
	    		.reader(pat_reader())
	    		.writer(pat_writer()).build();
	  }

	  @Bean
	  public FlatFileItemReader<PatientDTO> pat_reader() {
	    FlatFileItemReader<PatientDTO> reader = new FlatFileItemReader<>();
	    reader.setResource(new ClassPathResource("/testdata/patients_list.csv"));
	    reader.setLinesToSkip(1);
	    reader.setLineMapper(new DefaultLineMapper<PatientDTO>() {{
	      setLineTokenizer(new DelimitedLineTokenizer() {
	    	  
	    	  {setNames(new String[] {"id","patientID",
	    			  "name","surname","phone","city","language","age","preconditions","fitness","smoker","clinician","clinicianID",
	    			  "organization","organizationID","under_observation"});}
	      });
	      setFieldSetMapper(new PatientscsvMapper());
	      
	    }});
	    return reader;
	  }

	  @Bean
	  public MongoItemWriter<PatientDTO> pat_writer() {
	    MongoItemWriter<PatientDTO> writer = new MongoItemWriter<PatientDTO>();
	    writer.setTemplate(mongoTemplate);
	    writer.setCollection("PatientDTO");
	    return writer;
	  }

}
