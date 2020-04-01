package com.doctors.athome.rest.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.MongoClient;

@Controller
@RequestMapping("/api/dah")
public class IndexController {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private MongoClient mongoClient;
	
	@GetMapping
    public String index(Model model) {
        logger.log(Level.INFO, "Database name: {0}", mongoClient.listDatabaseNames().first());
        return "index";
    }

}
