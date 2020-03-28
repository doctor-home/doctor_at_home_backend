package com.doctors.athome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctors.athome.repos.PatientRepository;
import com.doctors.athome.repos.entities.PatientDTO;

@Service
public class PatientServiceImpl implements PatientService {
	
	private PatientRepository patientrepo;
	
	@Autowired
	public PatientServiceImpl(PatientRepository patient) {
		patientrepo = patient;
	}

	@Override
	public List<PatientDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientDTO findByClinicianID(String clinicianID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientDTO findById(String patientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(PatientDTO patient) {
		patientrepo.save(patient);

	}

	@Override
	public void deleteByID(String ID) {
		// TODO Auto-generated method stub

	}

}
