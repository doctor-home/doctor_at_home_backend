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

import com.doctors.athome.repos.entities.HealthReportDTO;

@EnableBatchProcessing
@Configuration
public class HealthreportscsvJob {
	  @Autowired
	  private StepBuilderFactory stepBuilderFactory;

	  @Autowired
	  private MongoTemplate mongoTemplate;

	  @Bean
	  public Step step4() {
	    return stepBuilderFactory.get("step4")
	    		.<HealthReportDTO, HealthReportDTO>chunk(10)
	    		.reader(hlth_reader())
	    		.writer(hlth_writer()).build();
	  }
	  
	  

	  @Bean
	  public FlatFileItemReader<HealthReportDTO> hlth_reader() {
	    FlatFileItemReader<HealthReportDTO> reader = new FlatFileItemReader<>();
	    reader.setResource(new ClassPathResource("/testdata/measurements.csv"));
	    reader.setLinesToSkip(1);
	    reader.setLineMapper(new DefaultLineMapper<HealthReportDTO>() {{
	      setLineTokenizer(new DelimitedLineTokenizer() {});
	      setFieldSetMapper(new HealthreportcsvMapper());
	      
	    }});
	    return reader;
	  }
	 
	  @Bean
	  public MongoItemWriter<HealthReportDTO> hlth_writer() {
	    MongoItemWriter<HealthReportDTO> writer = new MongoItemWriter<HealthReportDTO>();
	    writer.setTemplate(mongoTemplate);
	    writer.setCollection("HealthReportDTO");
	    return writer;
	  }

}
