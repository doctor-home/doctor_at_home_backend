package com.doctors.athome.repos.entities.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.ClinicianDTO;
import com.doctors.athome.repos.entities.HealthReportDTO;
import com.doctors.athome.repos.entities.PatientDTO;
import com.doctors.athome.repos.entities.PatientSummaryDTO;

@Component
public class PatientDTOListener extends AbstractMongoEventListener<PatientDTO> {

	@Autowired
    private MongoOperations mongoOperations;
	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<PatientDTO> event) {
		
		super.onBeforeConvert(event);
		final PatientDTO source = event.getSource();
		PatientSummaryDTO psum = source.getPatientSummary();
		if(psum != null) {
			//case new patient with default summary
			if(psum.getLastReport() == null) {
				HealthReportDTO lastHealthReport = lastHealthReport(source.getPatientID());
				if(lastHealthReport != null)
					psum.setLastReport(lastHealthReport);
				else {
					psum.setLastReport(new HealthReportDTO());
					
				}
				psum = mongoOperations.save(psum);
			}			
		}
		
		if(source.getClinicianID() != null) {
			ClinicianDTO clinician = mongoOperations.findById(source.getClinicianID(), ClinicianDTO.class);
			if (clinician != null) {
				clinician.addPatient(psum);
				mongoOperations.save(clinician);
			}
			
		
		}
	}

	
	private HealthReportDTO lastHealthReport(String patientID) {
		HealthReportDTO hlth = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("patientID").is(patientID));
		hlth = mongoOperations.findOne(query, HealthReportDTO.class);
		return hlth;
	}
	
}
