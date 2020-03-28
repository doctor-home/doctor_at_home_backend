package com.doctors.athome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctors.athome.repos.HealthReportRepository;
import com.doctors.athome.repos.entities.HealthReportDTO;

@Service
public class HealthReportServiceImpl implements HealthReportService {

	private HealthReportRepository healthreportRepo;
	
	@Autowired
	public HealthReportServiceImpl(HealthReportRepository healthreportRepo) {
		this.healthreportRepo = healthreportRepo;
	}

	
	@Override
	public List<HealthReportDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HealthReportDTO findHealthReport(Long patientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(HealthReportDTO healthReport) {
		healthreportRepo.save(healthReport);
		
	}

	

}
