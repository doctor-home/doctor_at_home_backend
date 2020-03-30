package com.doctors.athome.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.doctors.athome.repos.entities.Call;
import com.doctors.athome.repos.entities.PatientDTO;

public class CallServiceImpl implements CallService {

	private PatientService patientService;
	private final String DAH_TELEPHONE_NUMBER;
	
	@Autowired
	public CallServiceImpl(PatientService patientService) {
		this.patientService = patientService;
		DAH_TELEPHONE_NUMBER = "+14046668654";
	}
	
	@Override
	public void callPatients() {
		// TODO Auto-generated method stub

	}

	@Override
	public Call callPatient(String patientID) {
		PatientDTO patient = patientService.findById(patientID);
		if(patient!=null) {
			Call call = new Call(DAH_TELEPHONE_NUMBER, patient.getPhone(), patientID, null);
		}
		return null;
	}

}
