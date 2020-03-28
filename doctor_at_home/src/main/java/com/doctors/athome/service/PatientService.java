package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.PatientDTO;

public interface PatientService {
	
	public List<PatientDTO> findAll();
	
	public PatientDTO findByClinicianID(String clinicianID);
	
	public PatientDTO findById(String patientID);
	
	public PatientDTO save(PatientDTO patient);
	
	public PatientDTO updatePatient(PatientDTO patient);
	
	public void deleteByID(String patientID);
	

}
