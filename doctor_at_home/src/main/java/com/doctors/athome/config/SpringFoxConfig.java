package com.doctors.athome.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class SpringFoxConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String DEFAULT_INCLUDE_PATTERN = "/api/dah/.*";
    
 
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/dah/**"))
				.build()
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
	            .securitySchemes(Arrays.asList(apiKey()));
	}
	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
	            "Backend API",
	            "Doctor@Home patient monitoring software - API",
	            "version 0.0.1",
	            "http://doctorathome.org",
	            new Contact("Abidemi Shobayo-Eniola", 
	            		"https://www.linkedin.com/in/abidemi-shobayo-eniola-4a7968139", 
	            		"abidemi.shobayoeni@gmail.com"),
	            "License",
	            "License Url",
	            Collections.emptyList());
	}
	
	private SecurityContext securityContext() {
	    return SecurityContext.builder()
	            .securityReferences(defaultAuth())
	            .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
	            .build();
	}

	List<SecurityReference> defaultAuth() {        
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}
