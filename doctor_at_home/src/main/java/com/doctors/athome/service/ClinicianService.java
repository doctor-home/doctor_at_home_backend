package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.OrganizationDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;
import com.doctors.athome.repos.entities.UserDTO;

public interface ClinicianService {

	public ClinicianDTO save(ClinicianDTO clinician);
	public ClinicianDTO update(ClinicianDTO clinician);
	public List<ClinicianDTO> findAll();
	public List<PatientDTO> findPatients(String clinicianID);
	public List<PatientDTO> findUntreatedPatients(String clinicianID);
	public List<PatientSummaryDTO> getPatientSummaries(String clinicianID);
	public List<OrganizationDTO> findOrganization(String clinicianID);
	public ClinicianDTO findByID(String clinicianID);
	public void Delete(String clinicianID);
	public ClinicianDTO findByUsername(String username);
	public ClinicianDTO getCurrentClinician();
	public UserDTO findUserByID(String clinicianID);
	
	
}
