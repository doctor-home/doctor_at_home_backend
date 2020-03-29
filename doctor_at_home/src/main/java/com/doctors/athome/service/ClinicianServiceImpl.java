package com.doctors.athome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;

@Service
public class ClinicianServiceImpl implements ClinicianService {
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public ClinicianServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public ClinicianDTO save(ClinicianDTO clinician) {
		return mongoTemplate.save(clinician);
	}

	@Override
	public ClinicianDTO update(ClinicianDTO clinician) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClinicianDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientDTO> findPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientDTO> findUntreatedPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientSummaryDTO> getPatientSummaries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClinicianDTO findByID(String clinicianID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(String clinicianID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClinicianDTO findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClinicianDTO getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
