package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.HealthReportDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;

public interface PatientService {
	
	public List<PatientDTO> findAll();
	
	public PatientDTO findByClinicianID(String clinicianID);
	
	public PatientSummaryDTO getPatientSummary(String patientID);
	
	public PatientDTO findById(String patientID);
	
	public List<HealthReportDTO> findHealthReports(String patientID);
	
	public PatientDTO savePatient(PatientDTO patient);
	
	public HealthReportDTO saveHealthReport(HealthReportDTO healthReport);
	
	public PatientDTO updatePatient(PatientDTO patient);
	
	public void deleteByID(String patientID);
	

}
