package com.doctors.athome.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.athome.repos.entities.HealthReportDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;
import com.doctors.athome.rest.error.EntityNotFoundException;
import com.doctors.athome.service.PatientService;

@RestController
@RequestMapping("/api/dah/v0/patients")
public class PatientRestController {

	
	private final PatientService patientService;
	
	@Autowired
	public PatientRestController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@GetMapping
	public List<PatientDTO> findAll(){
		return patientService.findAll();
	}
	
	@GetMapping("/{patientID}")
	public PatientDTO findPatientByID(@PathVariable String patientID) {
		PatientDTO patient = patientService.findById(patientID);
		if(patient == null) {
			throw new EntityNotFoundException("Patient id not found - " + patientID);
		}
		return patient;		
	}
	
	@GetMapping("/{patientID}/summary")
	public PatientSummaryDTO findPatientSummary(@PathVariable String patientID) {
		PatientSummaryDTO sum = patientService.getPatientSummary(patientID);
		if(sum == null) {
			throw new EntityNotFoundException("No summary found for given patient Id - " + patientID);
		}
		return sum;		
	}
	
	@GetMapping("/{patientID}/health-reports")
	public List<HealthReportDTO> findPatientHealthreport(@PathVariable String patientID) {
		List<HealthReportDTO> hlth = patientService.findHealthReports(patientID);
		if(hlth == null || hlth.isEmpty()) {
			throw new EntityNotFoundException("Health report not found for given patient Id - " + patientID);
		}
		return hlth;		
	}
	
	@PostMapping
	public PatientDTO addPatient(@RequestBody PatientDTO patient) {
		if(patient.getPatientSummary() == null) {
			throw new RuntimeException("Patient summary is required");
		}
		return patientService.savePatient(patient);
	}
	
	@PostMapping("/health-report")
	public HealthReportDTO addPatientHealthreport(@RequestBody HealthReportDTO hlth) {
		if(hlth.getTimestamp() == null) {
			throw new RuntimeException("Time stamp for this health report is required");
		}
		return patientService.saveHealthReport(hlth);
	}
	
	@PutMapping
	public PatientDTO updatePatient(@RequestBody PatientDTO patient) {
		if(patient.getPatientID() == null) {
			throw new RuntimeException("Cannot update data, patientID is missing");
		}
		return patientService.updatePatient(patient);
	}
	
}

