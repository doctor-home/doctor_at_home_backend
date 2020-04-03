package com.doctors.athome.service;

import org.springframework.stereotype.Service;

import com.doctors.athome.repos.entities.CallDTO;

@Service
public interface CallService {

	public void callPatients();
	public CallDTO callPatient(String patientID);
}
