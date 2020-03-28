package com.doctors.athome.service;

import java.util.List;

import com.doctors.athome.repos.entities.HealthReportDTO;

public interface HealthReportService {
	
	public List<HealthReportDTO> findAll();
	public HealthReportDTO findHealthReportByID(String healthReportID);
	public HealthReportDTO findHealthReport(String patientID);
	public void save(HealthReportDTO healthReport);
	public void delete(String healthReportID);
	

}
