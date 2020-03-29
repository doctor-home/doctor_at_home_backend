package com.doctors.athome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.doctors.athome.config.GetUserWithCustomInterfaceController;
import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.HealthReportDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;

@Service
public class PatientServiceImpl implements PatientService {
	
	
	private final MongoTemplate mongoTemplate;
	private final GetUserWithCustomInterfaceController authController;
	
	@Autowired
	public PatientServiceImpl(MongoTemplate mongoTemplate, GetUserWithCustomInterfaceController authController) {
		this.mongoTemplate = mongoTemplate;
		this.authController = authController;
	}

	@Override
	public List<PatientDTO> findAll() {
		return mongoTemplate.findAll(PatientDTO.class);
	}

	@Override
	public PatientDTO findByClinicianID(String clinicianID) {
		PatientDTO patient = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("clinicianID").is(clinicianID));
		patient = mongoTemplate.findOne(query, PatientDTO.class);
		return patient;
	}

	@Override
	public PatientDTO findById(String patientID) {
		PatientDTO patient = null;
		if(!isPatient(patientID)) {
			throw new RuntimeException("Patient does not belong to current user - " + patientID);
		}
			
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(patientID));
		patient = mongoTemplate.findOne(query, PatientDTO.class);
		return patient;
	}

	@Override
	public PatientDTO savePatient(PatientDTO patient) {
		return mongoTemplate.save(patient);
	}

	@Override
	public void deleteByID(String ID) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(ID));
		mongoTemplate.remove(query, PatientDTO.class);

	}

	@Override
	public PatientDTO updatePatient(PatientDTO patient) {
		return mongoTemplate.save(patient);
	}

	@Override
	public List<HealthReportDTO> findHealthReports(String patientID) {
		List<HealthReportDTO> hlth = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("patientID").is(patientID));
		hlth = mongoTemplate.find(query, HealthReportDTO.class);
		return hlth;
	}

	@Override
	public HealthReportDTO saveHealthReport(HealthReportDTO healthReport) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(healthReport.getPatientID()));
		Update update = new Update();
		update.addToSet("lastReport", healthReport);
		mongoTemplate.findAndModify(query, update, PatientSummaryDTO.class);
		return mongoTemplate.save(healthReport);
	}
	
	private boolean isPatient(String patientID) {
		String username = authController.currentUserNameSimple();
		ClinicianDTO clinician = null;
		if(username != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(patientID).
					elemMatch(Criteria.where("username").is(username)));
			clinician = mongoTemplate.findOne(query, ClinicianDTO.class);
		}
		return clinician != null;
	}

	@Override
	public PatientSummaryDTO getPatientSummary(String patientID) {
		PatientSummaryDTO patient = null;
		if(!isPatient(patientID)) {
			throw new RuntimeException("Patient does not belong to current user - " + patientID);
		}
			
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(patientID));
		patient = mongoTemplate.findOne(query, PatientSummaryDTO.class);
		return patient;
	}
	
	

}
