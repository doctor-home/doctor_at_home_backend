package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;

public interface ClinicianService {

	public void save(ClinicianDTO clinician);
	public void update(ClinicianDTO clinician);
	public List<ClinicianDTO> findAll();
	public List<PatientSummaryDTO> findPatients();
	public ClinicianDTO findByID(String clinicianID);
	public void Delete(String clinicianID);
	
}
