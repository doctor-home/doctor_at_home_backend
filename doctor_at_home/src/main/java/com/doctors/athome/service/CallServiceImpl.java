package com.doctors.athome.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.doctors.athome.repos.entities.CallDTO;
import com.doctors.athome.repos.entities.PatientDTO;

@Service
public class CallServiceImpl implements CallService {

	private PatientService patientService;
	private RestTemplate restTemplate;
	@Value("${defaulttelephonenumber}")
	private String DAH_TELEPHONE_NUMBER;
	@Value("${healthreportposturl}")
	private String WEBHOOK;
	
	@Autowired
	public CallServiceImpl(PatientService patientService, RestTemplate restTemplate) {
		this.patientService = patientService;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public void callPatients() {
		// TODO Auto-generated method stub

	}

	@Override
	public CallDTO callPatient(String patientID) {
		PatientDTO patient = patientService.findById(patientID);
		CallDTO call = null;
		if(patient!=null) {
			try {
				call = new CallDTO(DAH_TELEPHONE_NUMBER, patient.getPhone(), patientID, new URL(WEBHOOK));
				return postRequest(call);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return call;
	}
	
	private CallDTO postRequest(CallDTO call) {
		String outboundUrl = "http://doctor-at-home-bff.eastus.azurecontainer.io:8080/outbound-call";

		HttpEntity<CallDTO> request = new HttpEntity<>(call);
		
		ResponseEntity<CallDTO> response = restTemplate.exchange(outboundUrl, HttpMethod.POST, request, CallDTO.class);
		return response.getBody();
		
	}
	
	
}
