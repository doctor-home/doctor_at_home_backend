package com.doctors.athome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.doctors.athome.config.AuthenticationFacade;
import com.doctors.athome.repos.ClinicianRepository;
import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.OrganizationDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;
import com.doctors.athome.repos.entities.UserDTO;

@Service
public class ClinicianServiceImpl implements ClinicianService {
	private final MongoTemplate mongoTemplate;
	
	private final AuthenticationFacade auth;
	
	
	@Autowired
	public ClinicianServiceImpl(MongoTemplate mongoTemplate, AuthenticationFacade auth) {
		this.auth = auth;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public ClinicianDTO save(ClinicianDTO clinician) {
		return mongoTemplate.save(clinician);
	}

	@Override
	public ClinicianDTO update(ClinicianDTO clinician) {
		
		return mongoTemplate.save(clinician);
	}

	@Override
	public List<ClinicianDTO> findAll() {
		return mongoTemplate.findAll(ClinicianDTO.class);
	}

	@Override
	public List<PatientDTO> findPatients(String clinicianID) {
		List<PatientDTO> patients = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("clinicianID").is(clinicianID));
		patients = mongoTemplate.find(query, PatientDTO.class);
		return patients;
	}

	@Override
	public List<PatientDTO> findUntreatedPatients(String clinicianID) {
		List<PatientDTO> patients = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("under_observation").
				is(false).and("summary").elemMatch(Criteria.where("clinicianID").is(clinicianID)));
		patients = mongoTemplate.find(query, PatientDTO.class);
		return patients;
	}

	@Override
	public List<PatientSummaryDTO> getPatientSummaries(String clinicianID) {
		List<PatientSummaryDTO> patients = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("clinicianID").is(clinicianID));
		patients = mongoTemplate.find(query, PatientSummaryDTO.class);
		return patients;
	}

	@Override
	public ClinicianDTO findByID(String clinicianID) {
		ClinicianDTO clinician = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(clinicianID));
		clinician = mongoTemplate.findOne(query, ClinicianDTO.class);
		return clinician;
	}
	
	@Override
	public UserDTO findUserByID(String clinicianID) {
		UserDTO user = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(clinicianID));
		user = mongoTemplate.findOne(query, UserDTO.class);
		return user;
	}

	@Override
	public void Delete(String clinicianID) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(clinicianID));
		mongoTemplate.remove(query, ClinicianDTO.class);
	}

	@Override
	public ClinicianDTO findByUsername(String username) {
		ClinicianDTO clinician = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		UserDTO user = mongoTemplate.findOne(query, UserDTO.class);
		if(user != null) {
			query = new Query();
			query.addCriteria(Criteria.where("_id").is(user.getClinicianId()));
			clinician = mongoTemplate.findOne(query, ClinicianDTO.class);
		}
		return clinician;
	}
	

	@Override
	public ClinicianDTO getCurrentClinician() {
		String username = auth.getCurrentUsername();
		ClinicianDTO clinician = null;
		if(username != null)
			clinician = findByUsername(username);
		return clinician;
	}
	
	

	@Override
	public List<OrganizationDTO> findOrganization(String clinicianID) {
		List<OrganizationDTO> org = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(clinicianID));
		org = mongoTemplate.find(query, OrganizationDTO.class);
		return org;
	}

	
}
