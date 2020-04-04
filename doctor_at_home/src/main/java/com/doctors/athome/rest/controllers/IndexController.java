package com.doctors.athome.rest.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.MongoClient;

@Controller
@RequestMapping
public class IndexController {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Value("${swaggerui.url}")
	private String swagger_url;
	
	@Value("${management.endpoints.web.base-path}")
	private String management_url;
	
	@Autowired
	private MongoClient mongoClient;
	
	@GetMapping("/index")
    public ModelAndView index() {
        logger.log(Level.INFO, "Database name: {0}", mongoClient.listDatabaseNames().first());
        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        model.addObject("swagger", swagger_url);
        model.addObject("management", management_url);
        return model;
    }
	
	@GetMapping("/docs")
	public String swagger(Model model) {
		return "redirect:/swagger-ui.html";
	}

}
