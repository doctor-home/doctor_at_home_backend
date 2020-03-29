package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;

public interface ClinicianService {

	public ClinicianDTO save(ClinicianDTO clinician);
	public ClinicianDTO update(ClinicianDTO clinician);
	public List<ClinicianDTO> findAll();
	public List<PatientDTO> findPatients();
	public List<PatientDTO> findUntreatedPatients();
	public List<PatientSummaryDTO> getPatientSummaries();
	public ClinicianDTO findByID(String clinicianID);
	public void Delete(String clinicianID);
	public ClinicianDTO findByUsername(String username);
	public ClinicianDTO getCurrentUser();
	
	
}
