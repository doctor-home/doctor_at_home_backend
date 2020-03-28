package com.doctors.athome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doctors.athome.repos.ClinicianRepository;
import com.doctors.athome.repos.HealthReportRepository;
import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;

public class ClinicianServiceImpl implements ClinicianService {
	private ClinicianRepository clinicianrepo;
	
	@Autowired
	public ClinicianServiceImpl(ClinicianRepository clinicianrepo) {
		this.clinicianrepo = clinicianrepo;
	}

	@Override
	public void save(ClinicianDTO clinician) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ClinicianDTO clinician) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ClinicianDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientSummaryDTO> findPatients() {
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

}
