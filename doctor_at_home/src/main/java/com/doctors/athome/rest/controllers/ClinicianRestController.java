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

import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.OrganizationDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;
import com.doctors.athome.rest.error.EntityNotFoundException;
import com.doctors.athome.service.ClinicianService;

@RestController
@RequestMapping("/api/dah/v0/clinician")
public class ClinicianRestController {

	private ClinicianService clinicianService;
	
	@Autowired
	public ClinicianRestController(ClinicianService clinicianService) {
		this.clinicianService = clinicianService;
	}
	
	@PostMapping
	public ClinicianDTO addClinician(@RequestBody ClinicianDTO clinician) {
		return clinicianService.save(clinician);
	}
	@PostMapping("/loginUser")
	public ClinicianDTO login() {
		return clinicianService.getCurrentUser();
	}
	@PutMapping
	public ClinicianDTO updateClinician(@RequestBody ClinicianDTO clinician) {
		return clinicianService.update(clinician);
	}
	
	@GetMapping("/clinicians")
	public List<ClinicianDTO> findAll(){
		return clinicianService.findAll();
	}
	
	@GetMapping("/{clinicianID}")
	public ClinicianDTO findClinician(@PathVariable String clinicianID) {
		ClinicianDTO clinician = clinicianService.findByID(clinicianID);
		if(clinician == null) {
			throw new EntityNotFoundException("Clinician id not found - " + clinicianID);
		}
		return clinician;
	}
	
	@GetMapping("/{clinicianID}/patients")
	public List<PatientDTO> findPatients(@PathVariable String clinicianID) {
		List<PatientDTO> patients = clinicianService.findPatients(clinicianID);
		if(patients == null) {
			throw new EntityNotFoundException("Clinician id not found - " + clinicianID);
		}
		return patients;
	}
	@GetMapping("/{clinicianID}/untreatedpatients")
	public List<PatientDTO> findUntreatedpatients(@PathVariable String clinicianID) {
		List<PatientDTO> patients = clinicianService.findUntreatedPatients(clinicianID);
		if(patients == null) {
			throw new EntityNotFoundException("Clinician id not found - " + clinicianID);
		}
		return patients;
	}
	@GetMapping("/{clinicianID}/patients/summary")
	public List<PatientSummaryDTO> getPatientSummaries(@PathVariable String clinicianID) {
		List<PatientSummaryDTO> patients = clinicianService.getPatientSummaries(clinicianID);
		if(patients == null) {
			throw new EntityNotFoundException("Clinician id not found - " + clinicianID);
		}
		return patients;
	}
	
	@GetMapping("/{clinicianID}/organization")
	public List<OrganizationDTO> findOrganizations(@PathVariable String clinicianID) {
		List<OrganizationDTO> patients = clinicianService.findOrganization(clinicianID);
		if(patients == null) {
			throw new EntityNotFoundException("Clinician id not found - " + clinicianID);
		}
		return patients;
	}
	
	@GetMapping("/current")
	public ClinicianDTO findCurrentUser() {
		ClinicianDTO clinician = clinicianService.getCurrentUser();
		if(clinician == null){
			throw new RuntimeException("No user is currently logged in");
		}
		return clinicianService.getCurrentUser();
	}
	
	
	
}
