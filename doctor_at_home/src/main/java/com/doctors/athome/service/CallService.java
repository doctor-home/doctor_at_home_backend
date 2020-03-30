package com.doctors.athome.service;

import org.springframework.stereotype.Service;

import com.doctors.athome.repos.entities.Call;

@Service
public interface CallService {

	public void callPatients();
	public Call callPatient(String patientID);
}
