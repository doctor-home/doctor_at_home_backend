package com.doctors.athome.repos.entities.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.doctors.athome.repos.entities.ClinicianDTO;
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
		PatientSummaryDTO sum = source.getPatientSummary();
		if(sum != null) {
			if(sum.getLastReport() != null) {
				mongoOperations.save(sum.getLastReport());
			}
			sum = mongoOperations.save(sum);
			if(source.getClinicianID() != null) {
				ClinicianDTO clinician = mongoOperations.findById(source.getClinicianID(), ClinicianDTO.class);
				clinician.addPatient(sum);
				mongoOperations.save(clinician);
			
			}
			
		}
		
	}
	
}
