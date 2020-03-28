package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.PatientDTO;

public interface PatientService {
	
	public List<PatientDTO> findAll();
	
	public PatientDTO findByClinicianID(String clinicianID);
	
	public PatientDTO findById(String patientID);
	
	public void save(PatientDTO patient);
	
	public void deleteByID(String ID);
	

}
